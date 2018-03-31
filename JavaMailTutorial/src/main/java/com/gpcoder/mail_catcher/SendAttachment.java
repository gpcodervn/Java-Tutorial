package com.gpcoder.mail_catcher;

import java.net.MalformedURLException;
import java.net.URL;

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

		// Cấu hình thông tin Email Server
		email.setHostName(MailConfig.MAILCATCHER_HOST_NAME);
		email.setSmtpPort(MailConfig.MAILCATCHER_SSL_PORT);

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
