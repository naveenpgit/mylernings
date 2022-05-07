package aws.ses;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLContext;
import java.security.Security;
import java.util.Properties;

import static org.joda.time.LocalDateTime.now;

public class EmailUsingSMTP {

	public static final String UTF_8 = "UTF-8";

	public static final String USERNAME = "AKIAXMRWDUMHIJJZU2A2";

	public static final String PASSWORD = "BHJC1GSqgGSf/QfGF9cSzg/3U3lsTs+Vcp8uqrxSbV+z";

	public static final String HOST = "email-smtp.ap-south-1.amazonaws.com";

	public static final int PORT = 587;

	public static final String PROTOCOL = "smtp";

	static {
		// in open jdk default TLSv1.2 is enabled , but spring javaMail needs TLSv1, hence enabling all
		Security.setProperty("jdk.tls.disabledAlgorithms", "");
	}

	static String FROM = "arunkkamath@gmail.com";

	static String TO = "naveen.p.g@gmail.com";

	static boolean WITH_ATTACHMENT = false;

	public static void main(String[] args) throws Exception {

		System.out.println(String.join(",", SSLContext.getDefault().getSupportedSSLParameters().getProtocols()));
		System.out.println(String.join(",", SSLContext.getDefault().createSSLEngine().getEnabledProtocols()));
		EmailUsingSMTP emailUsingSMTP = new EmailUsingSMTP();
		JavaMailSender mailSender = emailUsingSMTP.javaMailSender();
		mailSender.send(emailUsingSMTP.constructMailBody(mailSender));
		System.out.println("Done!!!");
	}

	public MimeMessage constructMailBody(JavaMailSender mailSender) throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, WITH_ATTACHMENT, UTF_8);
		helper.setFrom(FROM);
		helper.setTo(TO);
		helper.setSubject("Test SES-SMTP " + now());
		helper.setText("Test Email --- @" + now(), false);
		//	helper.setCc();
		// helper.setBcc();
		//	helper.setReplyTo();
		//	helper.addAttachment();
		return mimeMessage;
	}

	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties mailProperties = getProperties();
		mailSender.setJavaMailProperties(mailProperties);
		mailSender.setHost(HOST);
		mailSender.setPort(PORT);
		mailSender.setProtocol(PROTOCOL);
		mailSender.setUsername(USERNAME);
		mailSender.setPassword(PASSWORD);
		mailSender.setDefaultEncoding(UTF_8);
		return mailSender;
	}

	private Properties getProperties() {
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "email-smtp.ap-south-1.amazonaws.com");
		return mailProperties;
	}
}


