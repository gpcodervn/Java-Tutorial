package com.gpcoder.combine;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ObjectToXmlHelper {

	/*
	 * Chuyển đối tượng sang chuỗi xml
	 */
	public static <T> String convertToXml(T obj) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		sb.append(convertToXml(obj, 0));
		return sb.toString();
	}

	/*
	 * Chuyển đối tượng sang chuỗi xml
	 */
	private static <T> String convertToXml(T obj, int numOfTab) {
		StringBuilder sb = new StringBuilder();

		// Get Class of obj
		Class<?> clazz = obj.getClass();

		// Kiểm tra xem lớp này có được chú thích XmlRootElement hay không.
		boolean isXmlDoc = clazz.isAnnotationPresent(XmlRootElement.class);

		List<Field> fields;
		String name;
		String value;
		if (isXmlDoc) {
			// Lấy ra đối tượng XmlRootElement, chú thích trên lớp này.
			XmlRootElement rootNode = clazz.getAnnotation(XmlRootElement.class);

			sb.append(getTab(numOfTab)); // Add tab
			sb.append("<" + rootNode.name()); // Root element

			if (isNotEmpty(rootNode.namespace())) {
				sb.append(" xmlns=\"" + rootNode.namespace() + "\"");
			}

			fields = getFields(clazz, XmlAttribute.class);
			if (!fields.isEmpty()) {
				for (Field field : fields) {
					field.setAccessible(true);
					XmlAttribute ann = field.getAnnotation(XmlAttribute.class);
					name = ann.name();
					value = getValueOfField(field, obj);
					sb.append(" " + name + "=\"" + value + "\""); // Add attribute
				}
			}

			sb.append(">");
			sb.append("\n"); // Add new line

			fields = getFields(clazz, null);
			if (!fields.isEmpty()) {
				// Create xml elements
				for (Field field : fields) {
					field.setAccessible(true);
					if (field.isAnnotationPresent(XmlElementWrapper.class)) {
						sb.append(createXmlWrapper(field, obj, numOfTab + 1));
					} else if (field.isAnnotationPresent(XmlElement.class)) {
						sb.append(createXmlElement(field, obj, numOfTab + 1));
					}
				}
			}

			sb.append(getTab(numOfTab));
			sb.append("</" + rootNode.name() + ">"); // End root element
		}

		return sb.toString();
	}

	private static String createXmlWrapper(Field field, Object obj, int numOfTab) {
		StringBuilder sb = new StringBuilder();
		XmlElementWrapper ann = field.getAnnotation(XmlElementWrapper.class);
		String name = ann.name(); // Get Element's name
		sb.append(getTab(numOfTab)); // Create 1 tab
		sb.append("<" + name + ">"); // Start Element
		sb.append("\n"); // Add new line
		Collection<?> collections = getListValueOfField(field, obj);
		if (collections != null && !collections.isEmpty()) {
			// Create xml sub elements
			for (Object collection : collections) {
				sb.append(convertToXml(collection, numOfTab + 1)); // Increase tab
				sb.append("\n"); // Add new line
			}
		}
		sb.append(getTab(numOfTab)); // Create 1 tab
		sb.append("</" + name + ">"); // End Element
		sb.append("\n"); // Add new line
		return sb.toString();
	}

	private static String createXmlElement(Field field, Object obj, int numOfTab) {
		StringBuilder sb = new StringBuilder();
		XmlElement ann = field.getAnnotation(XmlElement.class);
		String name = ann.name(); // Get Element's name
		String value = getValueOfField(field, obj); // Get value of field
		sb.append(getTab(numOfTab)); // Create tab
		sb.append("<" + name + ">"); // Start Element
		sb.append(value); // Element's content
		sb.append("</" + name + ">"); // End Element
		sb.append("\n"); // Add new line
		return sb.toString();
	}

	// Kiểm tra chuỗi không rỗng
	private static boolean isNotEmpty(String str) {
		return str != null && !str.isEmpty();
	}

	// Lấy danh sách field có sử dụng Annotation ann
	private static List<Field> getFields(Class<?> clazz, Class<? extends Annotation> ann) {
		List<Field> fieldAttributes = new ArrayList<>();

		Field[] fields = clazz.getDeclaredFields();
		if (ann == null) {
			fieldAttributes.addAll(Arrays.asList(fields));
		} else {
			for (Field field : fields) {
				if (field.isAnnotationPresent(ann)) {
					fieldAttributes.add(field);
				}
			}
		}

		return fieldAttributes;
	}

	// Lấy giá trị kiểu chuỗi
	private static String getValueOfField(Field field, Object obj) {
		String value = "";
		try {
			value = String.valueOf(field.get(obj));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return value;
	}

	// Lấy giá trị kiểu Collection (List, ArrayList, Set, ...)
	private static Collection<?> getListValueOfField(Field field, Object obj) {
		Collection<?> collection = null;
		try {
			Object objValue = field.get(obj);
			if (objValue instanceof Collection) {
				collection = (Collection<?>) objValue;
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return collection;
	}

	// Lấy số dấu tab
	private static String getTab(int numOfTab) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= numOfTab; i++) {
			sb.append("\t"); // Thêm dấu tab.
		}
		return sb.toString();
	}

}
