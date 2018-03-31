package com.gpcoder.apache_common;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

import com.gpcoder.MailConfig;

public class SendHtmlEmail {

	public static void main(String[] args) throws EmailException, MalformedURLException {

		// Tạo đối tượng Email
		ImageHtmlEmail email = new ImageHtmlEmail();

		// Cấu hình thông tin Email Server
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

		// Định nghĩa URL cơ sở để xác định đúng vị trí nguồn dữ liệu (img,..)
		// (Trong trường hợp nó có đường dẫn tương đối, ví dụ thẻ img như bên dưới)
		URL url = new URL("https://gpcoder.com");

		email.setDataSourceResolver(new DataSourceUrlResolver(url));

		// Nội dung email
		String htmlContent = "<h1>Welcome to <a href=\"gpcoder.com\">GP Coder</a></h1>"
				+ "<img src=\"wp-content/uploads/2017/10/Facebook_Icon_GP_2-300x180.png\" " + "	width=\"300\" "
				+ "	height=\"180\" " + "	border=\"0\" " + "	alt=\"gpcoder.com\" />";
		email.setHtmlMsg(htmlContent);

		// Nội dung thay thế:
		// Trong trường hợp chương trình đọc email của người nhận ko hỗ trợ HTML
		email.setTextMsg("Your email client does not support HTML messages");

		// send message
		email.send();

		System.out.println("Message sent successfully");
	}
}
