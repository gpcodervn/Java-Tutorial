package com.gpcoder;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupExample {
	public static void main(String[] args) throws IOException {
		getTitleOfUrl();
		getTitleOfHtmlFile();
		getTitleOfHtmlString();
		getAllPostLinks();
		getAllPostImages();
		getFormParameters();
	}

	// Tạo Document từ URL và lấy title
	public static void getTitleOfUrl() throws IOException {
		Document doc = Jsoup.connect("https://gpcoder.com").get();
		String title = doc.title();
		System.out.println(title);
	}

	// Tạo Document từ file HTML và lấy title
	public static void getTitleOfHtmlFile() throws IOException {
		Document doc = Jsoup.parse("D:/WorkSpace/gpcoder/JSoupTutorial/index.html");
		String title = doc.title();
		System.out.println(title);
	}

	// Tạo Document từ chuỗi HTML và lấy title
	public static void getTitleOfHtmlString() throws IOException {
		String html = "<html><head><title>Java Tutorials</title></head>"
			+ "<body>Welcome to GP Coder</body></html>";
		Document doc = Jsoup.parse(html);
		String title = doc.title(); 
		System.out.println(title);
	}

	// Lấy tất cả liên kết của bài viết
	public static void getAllPostLinks() throws IOException {
		Document doc = Jsoup.connect("https://gpcoder.com").get();
		Elements links = doc.select(".entry-title a[href]");
		for (Element link : links) {
			System.out.println("\nlink : " + link.attr("href"));
			System.out.println("text : " + link.text());
		}
	}

	// Lấy tất cả ảnh đại diện của bài viết
	public static void getAllPostImages() throws IOException {
		Document doc = Jsoup.connect("https://gpcoder.com").get();  
		Elements images = doc.select("article img[src~=(?i)\\.(png|jpe?g|gif)]");
		for (Element image : images) {
			System.out.println("\nsrc : " + image.attr("src"));
			System.out.println("height : " + image.attr("height"));
			System.out.println("width : " + image.attr("width"));
			System.out.println("alt : " + image.attr("alt"));
		} 
	}

	// Lấy tất cả thông tin của HTML form
	public static void getFormParameters() throws IOException {
		Document doc = Jsoup.parse(new File("D:/WorkSpace/gpcoder/JSoupTutorial/register.html"), "UTF-8");
		Element loginform = doc.getElementById("registerform");

		Elements inputElements = loginform.getElementsByTag("input");
		for (Element inputElement : inputElements) {
			String key = inputElement.attr("name");
			String value = inputElement.attr("value");
			System.out.println("Param name: " + key + " \nParam value: " + value);
		}
	}
}
