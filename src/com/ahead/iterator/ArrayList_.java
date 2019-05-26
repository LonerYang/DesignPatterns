package com.ahead.iterator;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class ArrayList_<E> implements Collection_<E>{

	Object[] elements;

	private int size;

	public ArrayList_() {
		elements = new Object[16];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(E e) {
		if (size == elements.length) {
			Object[] newEle = new Object[elements.length + elements.length / 2];
			System.arraycopy(elements, 0, newEle, 0, elements.length);
			elements = newEle;
		}
		elements[size++] = e;
	}

	@Override
	public Iterator_ iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator_<E> {

		private int currentIndex;

		@Override
		public boolean hasNext() {
			return currentIndex < ArrayList_.this.size;
		}

		@Override
		public E next() {
			return (E) ArrayList_.this.elements[currentIndex++];
		}
	}

}
