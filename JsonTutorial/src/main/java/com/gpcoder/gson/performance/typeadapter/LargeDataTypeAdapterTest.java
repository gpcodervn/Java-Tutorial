package com.gpcoder.gson.performance.typeadapter;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.commons.lang3.time.StopWatch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gpcoder.gson.object.LargeData;

public class LargeDataTypeAdapterTest {

	public static void main(final String[] args) throws IOException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		// Configure GSON
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LargeData.class, new LargeDataTypeAdapter());
		gsonBuilder.setPrettyPrinting();

		final Gson gson = gsonBuilder.create();

		final LargeData data = new LargeData();
		data.create(10485760);

		final String json = gson.toJson(data);

		final File dir = new File("data");
		dir.mkdirs();

		try (PrintStream out = new PrintStream(new File(dir, "outputTypeAdapter.json"), "UTF-8")) {
			out.println(json);
		}

		stopWatch.stop();
		System.out.println("Done in " + stopWatch.getTime());
	}
}
