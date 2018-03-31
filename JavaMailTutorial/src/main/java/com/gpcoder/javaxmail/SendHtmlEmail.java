package com.gpcoder.javaxmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.gpcoder.MailConfig;

public class SendHtmlEmail {
	public static void main(String[] args) {

		// 1) get the session object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", MailConfig.HOST_NAME);
		props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", MailConfig.SSL_PORT);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
			}
		});

		// 2) compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MailConfig.APP_EMAIL));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(MailConfig.RECEIVE_EMAIL));

			// 3) create HTML content
			message.setSubject("HTML Message");
			String htmlContent = "<h1>Welcome to <a href=\"gpcoder.com\">GP Coder</a></h1>" +
					"<img src=\"https://gpcoder.com/wp-content/uploads/2017/10/Facebook_Icon_GP_2-300x180.png\" " + 
					"	width=\"300\" " + 
					"	height=\"180\" " + 
					"	border=\"0\" " + 
					"	alt=\"gpcoder.com\" />";
			message.setContent(htmlContent, "text/html");
			

			// 4) send message
			Transport.send(message);

			System.out.println("Message sent successfully");
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
}
