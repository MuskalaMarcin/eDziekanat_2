package edziekanat.utilities;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;

/**
 * Created by Marcin on 10.04.2016.
 */
public class MailUtils
{
    private static final String mailUsername = "edziekanat.pk";
    private static final String mailPassword = "trudnehaslo123";
    private static final String host = "smtp.gmail.com";

    /**
     * Method sending e-mail message with html body from default email address.
     * @param to recipents list
     * @param subject of message
     * @param body of message (in html)
     * @throws MessagingException
     */
    public static void sendFromGMail(String[] to, String subject, String body) throws MessagingException
    {
	Properties props = System.getProperties();
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.user", mailUsername);
	props.put("mail.smtp.password", mailPassword);
	props.put("mail.smtp.port", "587");
	props.put("mail.smtp.auth", "true");

	Session session = Session.getDefaultInstance(props);
	MimeMessage message = new MimeMessage(session);

	try
	{
	    message.setFrom(new InternetAddress(mailUsername));
	    LinkedList<InternetAddress> toAddress = new LinkedList<>();

	    for (String toString : to)
	    {
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toString));
	    }

	    message.setSubject(subject);
	    message.setText(body, "ISO-8859-2", "html");
	    Transport transport = session.getTransport("smtp");
	    transport.connect(host, mailUsername, mailPassword);
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	}
	catch (MessagingException me)
	{
	    me.printStackTrace();
	    throw me;
	}
    }
}
