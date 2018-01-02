package com.gpcoder.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnotationSuppressWarningsExample {
	class Child {
		public Date getDate(int year, int month, int date) {
			Date d = new Date(2017, 11, 30);
			return d;
		}
		public Date getDate2(int year, int month, int date) {
			@SuppressWarnings("deprecation")
			Date d = new Date(2017, 11, 30);
			return d;
		}
		@SuppressWarnings("deprecation")
		public Date getDate3(int year, int month, int date) {
			return new Date(2017, 11, 30);
		}

		public List<String> getList() {
			ArrayList list = new ArrayList();
			return (List<String>) list;
		}
		@SuppressWarnings("unchecked")
		public List<String> getList2() {
			@SuppressWarnings("rawtypes")
			ArrayList list = new ArrayList();
			return (List<String>) list;
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<String> getList3() {
			ArrayList list = new ArrayList();
			return (List<String>) list;
		}
	}
}
