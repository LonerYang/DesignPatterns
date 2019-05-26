package com.ahead.iterator;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class LinkedList_<E> implements Collection_<E> {

	Node<E> first;
	Node<E> last;

	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(E e) {
		//如果第一个为null说明是第一次添加
		if (first == null) {
			Node<E> node = new Node<>();
			node.pre = null;
			node.e = e;
			node.next = null;

			first = node;
			last = node;
			first.pre = null;
			last.next = null;
		} else {
			//否则就往尾部添加
			Node<E> node = new Node<>();
			last.next = node;
			node.pre = last;
			node.e = e;
			node.next = null;

			last = node;
		}
		size++;
	}

	@Override
	public Iterator_ iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator<E> implements Iterator_<E> {

		 private int currentIndex;

		@Override
		public boolean hasNext() {
			return currentIndex < LinkedList_.this.size;
		}

		@Override
		public E next() {
			Node tempNode = first;
			for (int i = 0; i < currentIndex; i++) {
				tempNode = tempNode.next;
			}
			currentIndex++;
			return (E) tempNode.e;
		}
	}

	private class Node<E>{
		Node pre;
		E e;
		Node next;
	}


}
