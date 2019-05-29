package com.ahead.state.v2;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class HappyMood implements Mood {
	@Override
	public void smile() {
		System.out.println("开心的笑");
	}

	@Override
	public void cry() {
		System.out.println("喜极而泣");
	}

	@Override
	public void say() {
		System.out.println("有趣的说话");
	}
}
