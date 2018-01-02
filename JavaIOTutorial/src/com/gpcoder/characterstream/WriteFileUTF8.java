package com.gpcoder.characterstream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriteFileUTF8 {
	public static void main(String[] args) throws IOException {

		File file = new File("data/file_utf8.txt");

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

		out.append("Website UTF-8").append("\r\n");
		out.append("?? UTF-8").append("\r\n");
		out.append("??????? UTF-8").append("\r\n");

		out.flush();
		out.close();
	}
}
