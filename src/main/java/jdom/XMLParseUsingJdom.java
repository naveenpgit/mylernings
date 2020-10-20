package jdom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

import java.io.File;
import java.util.List;

public class XMLParseUsingJdom {
	public static void main(String[] args) {
		SAXBuilder builder = new SAXBuilder(XMLReaders.NONVALIDATING);
		builder.setXMLReaderFactory(XMLReaders.NONVALIDATING);
		builder.setFeature("http://xml.org/sax/features/validation", false);
		builder.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
		builder.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		File xmlFile = new File("/home/naveenkumargoudar/Naveen/Personel/naveen_git/mylernings/resources/SampleResponse.xml");
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("LOAN_FEEDBACK");

			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				List childLists = node.getChildren("FRE_BORROWER_RESPONSE");

				for (int j = 0; j < childLists.size(); j++) {
					Element n = (Element) childLists.get(j);
					Attribute ssn = n.getAttribute("BorrowerSSN");
					Attribute crId = n.getAttribute("CreditReportIdentifier");

					System.out.println("BorrowerSSN = " + ssn.getValue() + "     CreditReportIdentifier = " + crId.getValue());

				}

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
