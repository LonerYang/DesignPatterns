package com.ahead.factory.abstactfactory;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/11
 */
public class EarthSchoolFactory implements SchoolFactory {
	@Override
	public Course createCourse() {
		return new Java();
	}

	@Override
	public Dormitory createDormitory() {
		return new FourDormitory();
	}

	@Override
	public Sport createSport() {
		return new Basketball();
	}
}
