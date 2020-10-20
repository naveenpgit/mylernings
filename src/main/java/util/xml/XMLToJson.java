package util.xml;

import com.tavant.finexp.common.exception.FinExpException;
import com.tavant.finexp.mismo.vo.Message;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static util.json.JSONUtils.fromFile;
import static util.json.JSONUtils.toJsonWithIndent;

public class XMLToJson {
    static String file = "D:\\Naveen\\Features\\3.4\\XML\\multipleapplications.xml";

    public static void main(String[] args) {
        System.out.println(
                toJsonWithIndent(
                        getMismoObject(
                                new ByteArrayInputStream(
                                        fromFile(file).replaceAll("ULAD:", "").getBytes(UTF_8)))));
    }

    static Message getMismoObject(InputStream is) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<Message> messageWrapper = (JAXBElement<Message>) unmarshaller.unmarshal(is);
            Message messsage = messageWrapper.getValue();
            return messsage;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FinExpException(e);
        }
    }
}
