package com.ahead.iterator;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class Main {

	public static void main(String[] args) {
		Collection_<String> linkedList = new ArrayList_<>();
		for (int i = 0; i < 10; i++) {
			linkedList.add("s" + i);
		}
		Iterator_ iterator = linkedList.iterator();

		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
