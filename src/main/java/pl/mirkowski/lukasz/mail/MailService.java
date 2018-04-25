package pl.mirkowski.lukasz.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

	// ---- dane do wysy³ki maila
	private static final String HOST = "smtp.gmail.com";
	private static final int PORT = 465;
	private static final String FROM = "javajavadoodoo@gmail.com";
	private static final String PASS = "javadoodoo";

	public void sendMail(String to, String subject, String content) throws MessagingException {

		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtps");
		properties.put("mail.smtps.auth", true);
		
		//inicjalizacja sesji
		Session mailSession = Session.getDefaultInstance(properties);
		
		//tworzenie wiadomoœci
		MimeMessage message = new MimeMessage(mailSession);
		message.setSubject(subject);
		message.setContent(content, "text/plain; charset=UTF-8");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//ustawienie po³¹czenia ze skrzynk¹ pocztow¹
		Transport transport = mailSession.getTransport();
		transport.connect(HOST, PORT, FROM, PASS);
		
		//wysy³anie wiadomoœci
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		
	}

}
