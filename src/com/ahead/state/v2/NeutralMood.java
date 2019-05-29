package com.ahead.state.v2;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class NeutralMood implements Mood {
	@Override
	public void smile() {
		System.out.println("微笑");
	}

	@Override
	public void cry() {
		System.out.println("小声哭泣");
	}

	@Override
	public void say() {
		System.out.println("正常说话");
	}
}
