package com.gpcoder.generic;

public class GenericArray<T> {
	private T[] array;

	// Contructor.
	public GenericArray(T[] array) {
		this.array = array;
	}

	public T[] getArray() {
		return array;
	}

	// Trả về phần tử cuối cùng của mảng.
	public T getLastElement() {
		if (this.array == null || this.array.length == 0) {
			return null;
		}
		return this.array[this.array.length - 1];
	}
}
