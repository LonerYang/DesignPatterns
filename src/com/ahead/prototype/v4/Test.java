package com.ahead.prototype.v4;

/**
 * 浅克隆
 * 	-对象类型的成员变量没有克隆
 * 深克隆
 *  -对象类型的成员变量也要克隆
 *
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person person1 = new Person();
		Person person2 = (Person) person1.clone();

		System.out.println(person1.location == person2.location);
		//反转person1对象中location的street
		person1.location.street.reverse();

		//person2对象中location的street也反转了（严格来说StringBuilder也需要克隆）
		System.out.println(person1 .location.street);
		System.out.println(person2.location.street);
	}
}

class Person implements Cloneable {
	private int age = 18;
	private String name = "Yang";
	Location location = new Location(new StringBuilder("神域"), 888);

	@Override
	public Object clone() throws CloneNotSupportedException {
		Person person = (Person) super.clone();
		person.location = (Location) location.clone();
		return person;
	}
}

class Location implements Cloneable{
	StringBuilder street;
	int roomNo;

	public Location(StringBuilder street, int roomNo) {
		this.street = street;
		this.roomNo = roomNo;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
