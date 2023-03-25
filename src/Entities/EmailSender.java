package Entities;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    String HOST;
    String USER_NAME;
    String PASSWORD;
    String RECIPIENT;
    String SUBJECT;
    String BODY;

    public EmailSender(String HOST, String USER_NAME,
            String PASSWORD,
            String RECIPIENT,
            String SUBJECT,
            String BODY) {
        this.HOST = HOST;
        this.USER_NAME = USER_NAME;
        this.PASSWORD = PASSWORD;
        this.RECIPIENT = RECIPIENT;
        this.SUBJECT = SUBJECT;
        this.BODY = BODY;
    }

    public void sendEmail() {
        Properties props = System.getProperties();
        String host = HOST;
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587"); // port from google website
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress toAddress = new InternetAddress(RECIPIENT);

            message.addRecipient(Message.RecipientType.TO, toAddress);

            message.setSubject(SUBJECT);
            message.setText(BODY);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}