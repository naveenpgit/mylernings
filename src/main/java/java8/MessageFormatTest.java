package java8;

import java.text.MessageFormat;

public class MessageFormatTest {
    public static final String JOB_STATUS = "DOCUMENT_UPLOAD_JOB_ACTIVE_REF_IDS";

    public static final String _JOB_STATUS_ = "{0}_DOCUMENT_UPLOAD_JOB_ACTIVE_REF_IDS";


    public static void main(String[] args) {
        System.out.println(MessageFormat.format(JOB_STATUS, "Naveen"));
        System.out.println(MessageFormat.format(_JOB_STATUS_, "Naveen"));
    }
}
