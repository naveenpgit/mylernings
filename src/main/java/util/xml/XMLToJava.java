package util.xml;

import com.tavant.finexp.common.exception.FinExpException;
import com.tavant.finexp.loan.models.Borrower;
import com.tavant.finexp.loan.models.Loan;
import com.tavant.finexp.loan.models.MailingAddress;
import com.tavant.finexp.loan.models.Urla;
import com.tavant.finexp.mismo.vo.*;
import org.apache.commons.collections.CollectionUtils;
import org.mvel2.MVEL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.mvel2.MVEL.eval;
import static org.mvel2.MVEL.evalToBoolean;

public class XMLToJava {

    static File file = new File("D:\\Naveen\\Features\\3.4\\XML\\DI-C01_v3.4 XML_Fixed Primary Attchd_02222019.xml");

    public static void main(String[] args) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement jaxbElement = (JAXBElement) unmarshaller.unmarshal(file);
        Message message = (Message) jaxbElement.getValue();

        messageToLoan(message);
    }

    private static void messageToLoan(Message message) {
        Loan loan = new Loan();

        /** Loan summery fields */
        loan.setLenderCaseNumber(MVEL
                .evalToString("?dealSets.?dealSet[0].?deals.?deal[0].?loans.?loan[0].?loanIdentifiers.?loanIdentifier[0].?loanIdentifier", message));
        loan.setAgencyCaseNumber(MVEL
                .evalToString("?dealSets.?dealSet[0].?deals.?deal[0].?loans.?loan[0].?loanIdentifiers.?loanIdentifier[0].?loanIdentifier", message));
        // TODO Check with BA --
        // evalToString("?dealSets.?dealSet[0].?deals.?deal[0].?loans.?loan[0].?loanIdentifiers.?loanIdentifier[0].?LoanIdentifierType", message)

        /** Urla section of loan */
        List<Relationship> relationshipList = getBorrowerRelationship(message);
        List<Party> partyList = getPartyList(message);
        List<Urla> urlas = new ArrayList<>();

        if (relationshipList.isEmpty()) {
            List<Borrower> borrowers = new ArrayList<>();
            Urla urla = new Urla();
            Party borrower = fetchParty(partyList, Optional.of("BORROWER_1"));
            borrowers.add(partyToBorrower(borrower));
            urla.setBorrowers(borrowers);
            urlas.add(urla);
        } else {
            IntStream.range(0, relationshipList.size()).forEach(index -> {
                Urla urla = new Urla();
                List<Borrower> borrowers = new ArrayList<>();
                Parties parties = new Parties();

                Optional<String> borrowerLabelTo = Optional.ofNullable(relationshipList.get(index).getTo());
                Party borrower = fetchParty(partyList, borrowerLabelTo);
                borrowers.add(partyToBorrower(borrower));

                Optional<String> borrowerLabelFrom = Optional.ofNullable(relationshipList.get(index).getFrom());
                Party coBorrower = fetchParty(partyList, borrowerLabelFrom);
                borrowers.add(partyToBorrower(coBorrower));

                urla.setBorrowers(borrowers);
                urlas.add(urla);
            });
        }

    }

    private static Borrower partyToBorrower(Party party) {
        Borrower borrower = new Borrower();
        try {
            borrower.setFirstName(evalToString("?individual.?name.?firstName", party));
            borrower.setLastName(evalToString("?individual.?name.?lastName", party));
            borrower.setMiddleName(evalToString("?individual.?name.?middleName", party));
            borrower.setSuffix(evalToString("?individual.?name.?suffixName", party));
            borrower.setSsn(evalToString("?taxpayerIdentifiers.?taxpayerIdentifier[0].?taxpayerIdentifierValue", party));

            // TODO Use Date Util - or consider ZoneInfo
            String borrowerBirthDate = evalToString("?roles.?role[0].?borrower.?borrowerDetail.?borrowerBirthDate", party);
            borrower.setDob(Optional.ofNullable(borrowerBirthDate).map(x -> LocalDate.parse(x)).orElse(null));

            borrower.setMaritalStatus(evalToString("?roles.?role[0].?borrower.?borrowerDetail.?maritalStatusType.?value", party));
            borrower.setNoOfDependents(Optional.ofNullable((BigInteger) eval("?roles.?role[0].?borrower.?borrowerDetail.?dependentCount", party))
                    .map(x -> x.intValueExact()).orElse(null));
            borrower.setAges(
                    Optional.ofNullable((BigInteger) eval("?roles.?role[0].?borrower.?dependents.?dependent[0].?DependentAgeYearsCount", party))
                            .map(x -> x.toString()).orElse(null));
            borrower.setPhoneNumber(Optional.ofNullable(getContactDetails(party, ContactPointRoleBase.HOME))
                    .map(homeContact -> evalToString("?contactPointTelephone.?contactPointTelephoneValue", homeContact)).orElse(null));
            borrower.setEmail(getEmail(party));
            borrower.setPresentAddress(getPresentAddress(party));
            borrower.setPreviousAddresses(getPreviousAddresses(party));
            borrower.setMailingAddress(getMailingAddress(party));
            borrower.setEmployer(getEmployer(party));
        } catch (Exception e) {
            // TODO Log the error
            throw new FinExpException(e);
        }
        return borrower;
    }

    private static List<com.tavant.finexp.loan.models.Employer> getEmployer(Party party) {
        return Optional.ofNullable((List<com.tavant.finexp.mismo.vo.Employer>) eval("?roles.?role[0].?borrower.?employers.?employer", party))
                .map(List::stream).orElse(Stream.empty()).map(mismoEmployerToPortalEmployer).collect(Collectors.toList());
    }

    public static Function<Residence, com.tavant.finexp.loan.models.Address> residenceToAddress = (residence) -> {
        com.tavant.finexp.loan.models.Address address = new com.tavant.finexp.loan.models.Address();
        address.setAddressLine(evalToString("?address.?addressAdditionalLineText", residence));
        address.setCity(evalToString("?address.?cityName", residence));
        address.setState(evalToString("?address.?stateCode", residence));
        address.setZip(evalToString("?address.?postalCode", residence));
        Integer noOfMonths = Optional.ofNullable((BigInteger) eval("?residenceDetail.?borrowerResidencyDurationMonthsCount", residence))
                .map(x -> x.intValueExact()).orElse(0);
        address.setNoOfYears(noOfMonths / 12);
        address.setNoOfMonths(noOfMonths);
        return address;
    };

    public static Function<com.tavant.finexp.mismo.vo.Address, MailingAddress> mismoAddressToMailingAddress = (address) -> {
        MailingAddress mailingAddress = new MailingAddress();
        mailingAddress.setAddressLine(evalToString("?addressLineText", address));
        mailingAddress.setCity(evalToString("?cityName", address));
        mailingAddress.setState(evalToString("?stateCode", address));
        mailingAddress.setZip(evalToString("?postalCode", address));
        return mailingAddress;
    };

    public static Function<com.tavant.finexp.mismo.vo.Employer, com.tavant.finexp.loan.models.Employer> mismoEmployerToPortalEmployer = (mismoEmp) -> {
        com.tavant.finexp.loan.models.Employer portalEmp = new com.tavant.finexp.loan.models.Employer();
        String employerName = evalToString("?legalEntity.?legalEntityDetail.?fullName", mismoEmp);
        String employerName_Alt = evalToString("?individual.?name.?fullName", mismoEmp);
        portalEmp.setEmployerName(Optional.ofNullable(employerName).orElse(employerName_Alt));

        String businessPhone = evalToString(
                "?legalEntity.?contacts.?contact[0].?contactPoints.?contactPoint[0].?contactPointTelephone.?contactPointTelephoneValue", mismoEmp);
        String businessPhone_Alt = evalToString("?individual.?contactPoints.?contactPoint[0].?contactPointTelephone.?contactPointTelephoneValue",
                mismoEmp);
        portalEmp.setBusinessPhone(Optional.ofNullable(businessPhone).orElse(businessPhone_Alt));
        portalEmp.setStreetAddress(evalToString("?address.?addressLineText", mismoEmp));
        portalEmp.setCity(evalToString("?address.?cityName", mismoEmp));
        portalEmp.setState(evalToString("?address.?stateCode", mismoEmp));
        portalEmp.setZip(evalToString("?address.?postalCode", mismoEmp));
        portalEmp.setPosition(evalToString("?employment.?employmentPositionDescription", mismoEmp));
        portalEmp.setIsSelfEmployment(evalToBoolean("?employment.?employmentBorrowerSelfEmployedIndicator", mismoEmp));
        portalEmp.setMonthlyIncome((BigDecimal) eval("?employment.?employmentMonthlyIncomeAmount", mismoEmp));
        return portalEmp;
    };

    public static List<com.tavant.finexp.loan.models.Address> getPreviousAddresses(Party party) {
        List<Residence> previousResidences = getResidenceAddresses(party, BorrowerResidencyBase.PRIOR);
        return CollectionUtils.isNotEmpty(previousResidences) ? previousResidences.stream().filter(x -> x != null).map(residenceToAddress)
                .collect(Collectors.toList()) : Collections.EMPTY_LIST;
    }

    public static com.tavant.finexp.loan.models.Address getPresentAddress(Party party) {
        List<Residence> currentResidence = getResidenceAddresses(party, BorrowerResidencyBase.CURRENT);
        return CollectionUtils.isNotEmpty(currentResidence) ? residenceToAddress.apply(currentResidence.get(0)) : new com.tavant.finexp.loan.models.Address();
    }

    public static MailingAddress getMailingAddress(Party party) {
        List<com.tavant.finexp.mismo.vo.Address> allAddresses = getAddresses(party, AddressBase.MAILING);
        return CollectionUtils.isNotEmpty(allAddresses) ? mismoAddressToMailingAddress.apply(allAddresses.get(0)) : new MailingAddress();
    }

    public static List<Residence> getResidenceAddresses(Party party, BorrowerResidencyBase residencyType) {
        return Optional.ofNullable((List<Residence>) eval("?roles.?role[0].?borrower.?residences.?residence", party)).map(List::stream)
                .orElse(Stream.empty()).filter(x -> residencyType == (BorrowerResidencyBase) eval("?residenceDetail.?borrowerResidencyType", x))
                .collect(Collectors.toList());
    }

    public static List<com.tavant.finexp.mismo.vo.Address> getAddresses(Party party, AddressBase addressType) {
        return Optional.ofNullable((List<com.tavant.finexp.mismo.vo.Address>) eval("?addresses.?address", party)).map(List::stream)
                .orElse(Stream.empty()).filter(x -> addressType == (AddressBase) eval("?addressType", x)).collect(Collectors.toList());
    }

    public static Residence getResidence(Party party, String addressType) {
        Object result = MVEL.eval("?roles.?role[0].?borrower.?residences.?residence", party);

        if (result != null) {
            List<Residence> residence = (List<Residence>) result;
            List<Residence> residences = residence.stream()
                    .filter(res -> res.getResidenceDetail().getBorrowerResidencyType().toString().equalsIgnoreCase(addressType))
                    .collect(Collectors.toList());
            return CollectionUtils.isNotEmpty(residences) ? residences.get(0) : new Residence();
        }
        return null;
    }

    public static String evalToString(String expression, Object input) {
        Object temp = eval(expression, input);
        return temp == null ? null : temp.toString();
    }

    public static ContactPoint getContactDetails(Party party, ContactPointRoleBase type) {

        return Optional.ofNullable((List<ContactPoint>) eval("?individual.?contactPoints.?contactPoint", party)).map(List::stream)
                .orElse(Stream.empty()).filter(x -> type == (ContactPointRoleBase) eval("?contactPointDetail.?contactPointRoleType", x)).findFirst()
                .orElse(null);

    }

    public static String getEmail(Party party) {
        return Optional.ofNullable((List<ContactPoint>) eval("?individual.?contactPoints.?contactPoint", party)).map(List::stream)
                .orElse(Stream.empty()).map(y -> evalToString("?contactPointEmail.?contactPointEmailValue", y)).filter(x -> x != null).findFirst()
                .orElse(null);
    }

    public static List<Relationship> getBorrowerRelationship(Message message) {
        List<Relationship> relationshipList = (List<Relationship>) Optional
                .ofNullable(eval("?dealSets.?dealSet[0].?deals.?deal[0].?relationships.?relationship", message)).orElse(new ArrayList<>());
        return relationshipList.stream()
                .filter(relationship -> relationship.getArcrole()
                        .contains("urn:fdc:mismo.org:2009:residential/ROLE_SharesSufficientAssetsAndLiabilitiesWith_ROLE"))
                .collect(Collectors.toList());
    }

    public static List<Party> getPartyList(Message message) {
        return (List<Party>) Optional.ofNullable(eval("?dealSets.?dealSet[0].?deals.?deal[0].?parties.?party", message)).orElse(new ArrayList<>());
    }

    private static Party fetchParty(List<Party> partyList, Optional<String> borrowerLabel) {
//        return borrowerLabel.map(label -> partyList.stream()
//                .filter(pty -> pty != null && borrowerLabel.get().equals(MismoUtils.getValue("?roles.?role[0].?label", pty))).findFirst()
//                .orElseGet(() -> new Party())).orElse(new Party());
        return null;

    }
}

