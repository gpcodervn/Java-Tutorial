package com.gpcoder.download;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileFromURL {
	public static void main(String[] args) {
		// https://spotlightenglish.com/listen/being-perfect1
		String url = "https://d165vjqq8ey7jy.cloudfront.net/mp3/27610/se-8075s.mp3"; // Download mp3 (High quality)
		// String url = "http://stream.xavang.com:2021/nhacvang/Chuyen-Nguoi-Con-Gai-Hai-Sim-Nhu-Quynh_ZWZ97879.mp3"; // Download mp3 (Normal quality)

		try {			
			downloadUsingNIO(url, "data/se-8075m.mp3");

			downloadUsingStream(url, "data/se-8075m-stream.mp3");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void downloadUsingStream(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection connect = (HttpURLConnection) url.openConnection();
		connect.setRequestMethod("GET");
		connect.connect();
		BufferedInputStream bis = new BufferedInputStream(connect.getInputStream());

		FileOutputStream fos = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = bis.read(buffer, 0, 1024)) != -1) {
			fos.write(buffer, 0, count);
		}
		fos.close();
		bis.close();
	}

	private static void downloadUsingNIO(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}
}
