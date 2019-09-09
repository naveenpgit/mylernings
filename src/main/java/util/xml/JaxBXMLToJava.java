package util.xml;

import org.json.JSONObject;
import org.json.XML;

import java.io.File;

public class JaxBXMLToJava {
    static File file = new File("E:\\naveen_git\\mylernings\\resources\\another_sample.xml");

    public static void main(String[] args) throws Exception {
        String xml_data = "<?xml version=\"1.0\" encoding=\"UTF-16\"?>\n<ULAD:URLA_TOTAL_EXTENSION xmlns:ULAD=\"http://www.datamodelextension.org/Schema/ULAD\"><ULAD:URLATotalSellerCreditsAmount>3500</ULAD:URLATotalSellerCreditsAmount><ULAD:URLATotalOtherCreditsAmount>4500</ULAD:URLATotalOtherCreditsAmount>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</ULAD:URLA_TOTAL_EXTENSION>";

        //converting xml to json
        JSONObject obj = XML.toJSONObject(xml_data);
        System.out.println(obj.toString());
    }
}
