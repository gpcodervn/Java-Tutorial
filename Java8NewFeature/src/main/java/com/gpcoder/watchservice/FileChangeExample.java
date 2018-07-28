package com.gpcoder.watchservice;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * http://www.javatechblog.com/java/watchservice-in-java-with-example-program/
 *
 */
public class FileChangeExample {

	public static void main(String[] args) throws IOException {

		/*
		 * The first step is to create a new WatchService by using the newWatchService()
		 * method in the FileSystem class
		 */

		WatchService watchService = FileSystems.getDefault().newWatchService();

		/*
		 * Next, register one or more objects with the watch service. Any object that
		 * implements the Watchable interface can be registered. The Path class
		 * implements the Watchable interface, so each directory to be monitored is
		 * registered as a Path object.
		 */

		Path path = Paths.get("D://WatchFolder");

		/**
		 * When registering an object with the watch service, you specify the types of
		 * events that you want to monitor. The supported StandardWatchEventKinds event
		 * types follow: 
		 * ENTRY_CREATE – A directory entry is created. 
		 * ENTRY_DELETE – A directory entry is deleted. 
		 * ENTRY_MODIFY – A directory entry is modified.
		 * OVERFLOW – Indicates that events might have been lost or discarded. You do
		 * not have to register for the OVERFLOW event to receive it.
		 */

		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);

		System.out.println("Watch service registered for dir: " + path.toString());

		WatchKey key = null;

		while (true) { // create an infinite loop to wait for events
			try {
				/*
				 * Get a watch key. The take() method returns a queued key. If no queued key is
				 * available, this method waits.
				 */

				System.out.println("Waiting for key to be signalled...");
				key = watchService.take();

				/*
				 * Process the pending events for the key. You fetch the List of WatchEvents
				 * from the pollEvents() method.
				 */

				for (WatchEvent<?> event : key.pollEvents()) {

					/*
					 * Retrieve the type of event by using the kind() method.
					 */
					Kind<?> kind = event.kind();

					/*
					 * Retrieve the file name associated with the event. The file name is stored as
					 * the context of the event, so the context() method is used to retrieve it.
					 */

					System.out.println("Event on " + event.context() + " is " + kind);
				}
			} catch (InterruptedException e) {
				System.out.println("InterruptedException: " + e.getMessage());
			}

			/*
			 * After the events for the key have been processed, you need to put the key
			 * back into a ready state by invoking reset(). If this method returns false,
			 * the key is no longer valid and the loop can exit. This step is very
			 * important. If you fail to invoke reset, this key will not receive any further
			 * events.
			 */

			boolean reset = key.reset();
			if (!reset) {
				break;
			}
		}
	}
}
