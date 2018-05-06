package com.gpcoder.stream.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileWithStreamExample {

	public static void main(String args[]) {

		String fileName = "lines.txt";

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream //
					.onClose(() -> System.out.println("Done!")) //
					.filter(s -> s.startsWith("line3")) //
					.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
