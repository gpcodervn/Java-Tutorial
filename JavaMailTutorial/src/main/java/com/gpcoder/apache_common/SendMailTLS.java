package com.gpcoder.apache_common;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.gpcoder.MailConfig;

public class SendMailTLS {

	public static void main(String[] args) throws EmailException {

		// Tạo đối tượng Email
		Email email = new SimpleEmail();

		// Cấu hình thông tin Email Server
		email.setHostName(MailConfig.HOST_NAME);
		email.setSmtpPort(MailConfig.TSL_PORT);
		email.setAuthenticator(new DefaultAuthenticator(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD));
		email.setTLS(true);

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
