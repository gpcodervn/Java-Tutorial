package com.gpcoder.watchservice;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DirectoryWatchExample {

	public static void main(String[] args) throws IOException {
		WatchService watcher = FileSystems.getDefault().newWatchService();
		Path dir = Paths.get("C:/uploads");
		dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);

		System.out.println("Watch Service registered for dir: " + dir.getFileName());

		WatchKey key = null;
		while (true) {
			try {
				// System.out.println("Waiting for key to be signalled...");
				key = watcher.take();
			} catch (InterruptedException ex) {
				System.out.println("InterruptedException: " + ex.getMessage());
				return;
			}

			for (WatchEvent<?> event : key.pollEvents()) {
				// Retrieve the type of event by using the kind() method.
				WatchEvent.Kind<?> kind = event.kind();
				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				Path fileName = ev.context();
				if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
					System.out.printf("A new file %s was created.%n", fileName.getFileName());
				} else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
					System.out.printf("A file %s was modified.%n", fileName.getFileName());
				} else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
					System.out.printf("A file %s was deleted.%n", fileName.getFileName());
				}
			}

			boolean valid = key.reset();
			if (!valid) {
				break;
			}
		}
	}
}
