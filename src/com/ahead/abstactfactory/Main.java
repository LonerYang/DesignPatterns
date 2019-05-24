package com.ahead.abstactfactory;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/11
 */
public class Main {
	public static void main(String[] args) {
		SchoolFactory schoolFactory = new GodPlaceSchoolFactory();
		schoolFactory.createCourse().study();
		schoolFactory.createDormitory().sleep();
		schoolFactory.createSport().play();
	}
}
