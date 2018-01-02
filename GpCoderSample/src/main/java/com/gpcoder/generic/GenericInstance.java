package com.gpcoder.generic;

public class GenericInstance<T> {
	private T obj;

	public GenericInstance(Class<T> aClazz) 
			throws InstantiationException, IllegalAccessException {
		this.obj = (T) aClazz.newInstance();
	}

	public T getObj() {
		return obj;
	}
}
