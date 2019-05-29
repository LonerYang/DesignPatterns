package com.ahead.state.v2;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class SadMood implements Mood {
	@Override
	public void smile() {
		System.out.println("苦笑");
	}

	@Override
	public void cry() {
		System.out.println("伤心的哭");
	}

	@Override
	public void say() {
		System.out.println("脾气不好的说话");
	}
}
