package com.ahead.strategy;

/**
 * 自定义比较器
 * @author Yang
 *
 * @param <T>
 */
public interface Comparator<T> {
	int compare(T o1, T o2);
}
