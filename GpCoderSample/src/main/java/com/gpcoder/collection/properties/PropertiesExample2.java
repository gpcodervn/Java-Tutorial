package com.gpcoder.collection.properties;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesExample2 {
	public static void main(String[] args) throws Exception {
		// get system properties
		Properties p = System.getProperties();
		Set<Entry<Object, Object>> set = p.entrySet();

		// show system properties
		Iterator<Entry<Object, Object>> itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry<Object, Object> entry = itr.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}
}