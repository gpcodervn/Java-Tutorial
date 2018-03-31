package com.gpcoder.mail_catcher;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.gpcoder.MailConfig;

public class SendToMailCatcher {

	public static void main(String[] args) throws EmailException {
		// Tạo đối tượng Email
		Email email = new SimpleEmail();

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

		// send message
		email.send();

		System.out.println("Message sent successfully");
	}
}
