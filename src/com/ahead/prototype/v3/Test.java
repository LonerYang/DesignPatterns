package com.ahead.prototype.v3;

/**
 * 浅克隆
 * 	-对象类型的成员变量没有克隆
 * 深克隆
 *  -对象类型的成员变量也要克隆
 *  String类型的成员变量不需要克隆，因为String类型最终都是指向常量池中，你修改某个String类型的值
 *  	-不会修改常量池中那个字符串的值，而是会让当前字符串的引用指向常量池中的另外一个字符串，所以互不干扰
 *  	-String类没有实现Cloneable接口所以也无法克隆
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person person1 = new Person();
		Person person2 = (Person) person1.clone();

		System.out.println(person1.location == person2.location);
		//修改person1中location的street
		person1.location.street = "地球";

		//没有影响person2的location的street
		System.out.println(person1 .location.street);
		System.out.println(person2.location.street);
	}
}

class Person implements Cloneable {
	private int age = 18;
	private String name = "Yang";
	Location location = new Location("神域", 888);

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Person person = (Person) super.clone();
		person.location = (Location) location.clone();
		return person;
	}
}

class Location implements Cloneable{
	String street;
	int roomNo;

	public Location(String street, int roomNo) {
		this.street = street;
		this.roomNo = roomNo;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
