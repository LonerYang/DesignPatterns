package com.ahead.iterator;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public interface Collection_<E> {
	int size();

	void add(E e);

	Iterator_ iterator();
}
