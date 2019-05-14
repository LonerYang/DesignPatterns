package com.ahead.factory.abstactfactory;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/11
 */
public class GodPlaceSchoolFactory implements SchoolFactory {
	@Override
	public Course createCourse() {
		return new Fly();
	}

	@Override
	public Dormitory createDormitory() {
		return new Tower();
	}

	@Override
	public Sport createSport() {
		return new Wrestle();
	}
}
