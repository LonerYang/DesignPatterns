package com.ahead.builder;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class Person {
	private int id;
	private String name;
	private int age;
	private double weight;
	private double salary;
	private Location location;

	public static class PersonBuilder {
		Person person = new Person();

		public PersonBuilder buildBasic(int id, String name, int age) {
			person.id = id;
			person.name = name;
			person.age = age;
			return this;
		}

		public PersonBuilder buildWeight(double weight) {
			person.weight = weight;
			return this;
		}

		public PersonBuilder buildLocation(String street, int roomNo) {
			Location location = new Location(street, roomNo);
			person.location = location;
			return this;
		}

		public Person build() {
			return person;
		}
	}

}

class Location {
	private String street;
	private int roomNo;

	Location(String street, int roomNo) {
		this.street = street;
		this.roomNo = roomNo;
	}
}
