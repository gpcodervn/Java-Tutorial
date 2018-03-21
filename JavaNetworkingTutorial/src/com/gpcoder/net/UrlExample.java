package com.gpcoder.net;

import java.io.IOException;
import java.net.URL;

public class UrlExample {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.gpcoder.com:80/java/index.html?page=1&order=desc#java-core");
			System.out.println("URL : " + url.toString());
			System.out.println("protocol : " + url.getProtocol());
			System.out.println("authority : " + url.getAuthority());
			System.out.println("file name : " + url.getFile());
			System.out.println("host : " + url.getHost());
			System.out.println("path : " + url.getPath());
			System.out.println("port : " + url.getPort());
			System.out.println("default port : " + url.getDefaultPort());
			System.out.println("query : " + url.getQuery());
			System.out.println("ref : " + url.getRef());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
