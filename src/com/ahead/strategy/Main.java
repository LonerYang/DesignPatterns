package com.ahead.strategy;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		Student[] students = {new Student(3, 5), new Student(1, 6), new Student(2, 3)};
		
		//使用策略模式达到传不同的策略过去就能根据我的策略来进行排序，不需要修改sort方法
//		new Sorter<Student>().sort(students, new StudentAgeComparator());
		
		new Sorter<Student>().sort(students, new StudentIdComparator());
		System.out.println(Arrays.toString(students));
	}

}
