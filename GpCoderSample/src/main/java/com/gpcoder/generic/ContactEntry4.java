package com.gpcoder.generic;

public class ContactEntry4<K, V, T> extends KeyValuePair<K, V> {

	private T obj;

	public ContactEntry4(K key, V value, T obj) {
		super(key, value);
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

}
