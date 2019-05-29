package com.ahead.prototype.v1;

/**
 * 浅克隆
 * 	-对象类型的成员变量没有克隆
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person person1 = new Person();
		Person person2 = (Person) person1.clone();

		System.out.println(person1.location == person2.location);
		person1.location.street = "地球";
		System.out.println(person2.location.street);
	}
}

class Person implements Cloneable {
	private int age = 18;
	private String name = "Yang";
	Location location = new Location("神域", 888);

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Location {
	String street;
	int roomNo;

	public Location(String street, int roomNo) {
		this.street = street;
		this.roomNo = roomNo;
	}
}
