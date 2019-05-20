package com.ahead.flyweight;

/**
 * Java中的字符串常量池就是用的享元模式
 * @author Yang
 * @version 1.0
 * @time 2019/5/20
 */
public class StringTest {
	public static void main(String[] args) {
		//第一次使用时就将abc字符串放入常量池中
		String s1 = "abc";
		//这里指向的常量池中的abc
		String s2 = "abc";
		//在堆内存创建一个对象，堆内存指向常量池中的abc，但是堆中的对象地址是不同的
		String s3 = new String("abc");
		String s4 = new String("abc");

		//true
		System.out.println(s1 == s2);
		//false
		System.out.println(s2 == s3);
		//false
		System.out.println(s3 == s4);
		//true
		System.out.println(s3.intern() == s4.intern());
	}
}
