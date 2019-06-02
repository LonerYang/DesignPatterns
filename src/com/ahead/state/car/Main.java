package com.ahead.state.car;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class Main {
	public static void main(String[] args) {
		Car car = new Car(new Running());
		car.closeDoor();
		car.openDoor();
		car.runCar();
		car.stopCar();
	}
}
