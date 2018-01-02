package com.gpcoder.generic;

import java.lang.reflect.Array;

public class GenericArrayContructor<T> {
	private final int size = 10;
	private Class<T> aClazz;

	private T[] myArray;

	public GenericArrayContructor(Class<T> aClazz) {
		this.aClazz = aClazz;
		myArray = (T[]) Array.newInstance(aClazz, size);
	}

	public T[] getMyArray() {
		return this.myArray;
	}
}
