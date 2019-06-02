package com.ahead.state.car;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public interface CarState {
	void openDoor();
	void closeDoor();
	void runCar();
	void stopCar();
}
