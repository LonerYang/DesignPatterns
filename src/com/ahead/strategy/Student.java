package com.ahead.strategy;

public class Student {
	
	private int id;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student(int id, int age) {
		super();
		this.id = id;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + "]";
	}
}
