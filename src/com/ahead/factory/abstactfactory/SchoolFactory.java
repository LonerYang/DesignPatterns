package com.ahead.factory.abstactfactory;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/11
 */
public interface SchoolFactory {

	Course createCourse();

	Dormitory createDormitory();

	Sport createSport();
}
