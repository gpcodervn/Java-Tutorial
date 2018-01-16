package com.gpcoder.gson.performance.typeadapter;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.gpcoder.gson.object.LargeData;

public class LargeDataTypeAdapter extends TypeAdapter<LargeData> {

	@Override
	public LargeData read(final JsonReader in) throws IOException {
		throw new UnsupportedOperationException("Coming soon");
	}

	@Override
	public void write(final JsonWriter out, final LargeData data) throws IOException {
		out.beginObject();
		out.name("numbers");
		out.beginArray();
		for (final long number : data.getNumbers()) {
			out.value(number);
		}
		out.endArray();
		out.endObject();
	}
}