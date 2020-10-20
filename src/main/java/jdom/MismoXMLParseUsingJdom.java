package jdom;

import org.jdom2.Document;
import org.jdom2.Text;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static java.text.MessageFormat.format;

public class MismoXMLParseUsingJdom {
	public static void main(String[] args) {
		Map<String, String> result = new HashMap<>();
		SAXBuilder builder = getSAXBuilder();
		File xmlFile = new File("/home/naveenkumargoudar/Naveen/Personel/naveen_git/mylernings/resources/SampleResponse_Mismo.xml");
		try {
			Document document = (Document) builder.build(xmlFile);
			document.getContent(new ElementFilter("LPALoanAssessmentServiceResponse")).get(0)
					.getContent(new ElementFilter("MESSAGE")).get(0)
					.getContent(new ElementFilter("DEAL_SETS")).get(0)
					.getContent(new ElementFilter("DEAL_SET")).get(0)
					.getContent(new ElementFilter("DEALS")).get(0)
					.getContent(new ElementFilter("DEAL")).stream()
					.filter(deal -> {    // pick LPA_RESPONSE deal
						return deal.getContent(new ElementFilter("ABOUT_VERSIONS")).get(0)
								.getContent(new ElementFilter("ABOUT_VERSION")).get(0)
								.getContent(new ElementFilter("DataVersionName")).get(0)
								.getContent(0).getValue().equals("LPA_RESPONSE");
					}).findFirst().get()
					.getContent(new ElementFilter("PARTIES")).get(0)
					.getContent(new ElementFilter("PARTY")).stream()
					.filter(party -> { //Pick only borrower parties
						return party.getContent(new ElementFilter("ROLES")).get(0)
								.getContent(new ElementFilter("ROLE")).get(0)
								.getContent(new ElementFilter("ROLE_DETAIL")).get(0)
								.getContent(new ElementFilter("PartyRoleType")).get(0)
								.getContent(0).getValue().equals("Borrower");
					})
					.forEach(party -> {
						Text CreditReportIdentifier_v = (Text) party.getContent(new ElementFilter("ROLES")).get(0)
								.getContent(new ElementFilter("ROLE")).get(0)
								.getContent(new ElementFilter("BORROWER")).get(0)
								.getContent(new ElementFilter("BORROWER_DETAIL")).get(0)
								.getContent(new ElementFilter("CreditReportIdentifier")).get(0)
								.getContent(0);

						Text TaxpayerIdentifierValue_v = (Text) party.getContent(new ElementFilter("TAXPAYER_IDENTIFIERS")).get(0)
								.getContent(new ElementFilter("TAXPAYER_IDENTIFIER")).get(0)
								.getContent(new ElementFilter("TaxpayerIdentifierValue")).get(0)
								.getContent(0);

						result.put(TaxpayerIdentifierValue_v.getText(), CreditReportIdentifier_v.getText());
					});

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		result.entrySet().forEach(entry -> System.out.println(format("BorrowerSSN = {0} ==== CreditReportIdentifier = {1}", entry.getKey(), entry.getValue())));
	}

	static SAXBuilder getSAXBuilder() {

		SAXBuilder builder = new SAXBuilder(XMLReaders.NONVALIDATING);
		builder.setXMLReaderFactory(XMLReaders.NONVALIDATING);
		builder.setFeature("http://xml.org/sax/features/validation", false);
		builder.setFeature(
				"http://apache.org/xml/features/nonvalidating/load-dtd-grammar",
				false);
		builder.setFeature(
				"http://apache.org/xml/features/nonvalidating/load-external-dtd",
				false);
		return builder;
	}
}
