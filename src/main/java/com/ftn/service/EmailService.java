package com.ftn.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public static void sendMail(String emailAdresa, String naslov, String poruka) throws MessagingException {
        JavaMailSenderImpl posiljalac = new JavaMailSenderImpl();
        posiljalac.setDefaultEncoding("UTF-8");

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        posiljalac.setJavaMailProperties(properties);

        Session mailSession = Session.getDefaultInstance(properties, null);
        MimeMessage mailMessage = new MimeMessage(mailSession);

        final InternetAddress recipient = new InternetAddress(emailAdresa);

        mailMessage.addRecipient(Message.RecipientType.TO, recipient);
        mailMessage.setSubject(naslov);
        mailMessage.setContent(poruka, "text/html");

        Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "nijemidosadno@gmail.com", "Nalog je uspesno aktiviran :)");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
    }
	
}
