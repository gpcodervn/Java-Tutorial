package com.gpcoder.gson.performance.serializer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.lang3.time.StopWatch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gpcoder.gson.object.LargeData;

public class LargeDataSerializerStreamingTest {

	public static void main(final String[] args) throws IOException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		// Configure GSON
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LargeData.class, new LargeDataSerializer());
		gsonBuilder.setPrettyPrinting();

		final Gson gson = gsonBuilder.create();

		final LargeData data = new LargeData();
		data.create(10485760);

		final File dir = new File("data");
		dir.mkdirs();

		try (OutputStream os = new FileOutputStream(new File(dir, "outputSerialiserStreaming.json"));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
			gson.toJson(data, out);
		}

		stopWatch.stop();
		System.out.println("Done in " + stopWatch.getTime());
	}
}
