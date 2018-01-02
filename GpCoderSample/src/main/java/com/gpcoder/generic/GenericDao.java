package com.gpcoder.generic;

public interface GenericDao<T> {

	void insert(T obj);

	void update(T obj);

}
