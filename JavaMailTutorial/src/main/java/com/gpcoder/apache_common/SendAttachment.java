package com.gpcoder.apache_common;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import com.gpcoder.MailConfig;

public class SendAttachment {

	public static void main(String[] args) throws EmailException, MalformedURLException {

		// Tạo một đối tượng đính kèm
		String filename = "data/myfile.txt";
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(filename);
		attachment.setURL(new URL("https://gpcoder.com"));
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Gp coder");
		attachment.setName("gpcoder");

		// Tạo đối tượng Email
		MultiPartEmail email = new MultiPartEmail();

		// Cấu hình
		email.setHostName(MailConfig.HOST_NAME);
		email.setSmtpPort(MailConfig.SSL_PORT);
		email.setAuthenticator(new DefaultAuthenticator(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD));
		email.setSSLOnConnect(true);

		// Người gửi
		email.setFrom(MailConfig.APP_EMAIL);

		// Người nhận
		email.addTo(MailConfig.RECEIVE_EMAIL);

		// Tiêu đề
		email.setSubject("Testing Subject");

		// Nội dung email
		email.setMsg("Welcome to gpcoder.com");

		// Thêm đính kèm
		email.attach(attachment);

		// Gửi email
		email.send();

		System.out.println("Sent!");
	}
}
