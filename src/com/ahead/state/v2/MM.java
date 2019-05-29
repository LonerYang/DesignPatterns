package com.ahead.state.v2;

/**
 * 把状态抽取出来，每次增加新的状态不用修改源码
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class MM {
	Mood mood;

	public MM(Mood mood) {
		this.mood = mood;
	}
	public void smile() {
		mood.smile();
	}

	public void cry() {
		mood.cry();
	}

	public void say() {
		mood.say();
	}
}
