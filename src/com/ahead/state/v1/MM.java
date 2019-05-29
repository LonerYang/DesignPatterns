package com.ahead.state.v1;

/**
 * 如果MM增加了新的心情状态就要修改每个方法的代码；很麻烦
 *
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
enum MMState {HAPPY, SAD}

public class MM {

	MMState mmState;

	public MM(MMState mmState) {
		this.mmState = mmState;
	}

	public void smile() {
		switch (mmState) {
			case HAPPY:
				System.out.println("开兴的笑");
				break;
			case SAD:
				System.out.println("哭");
				break;
			default:
				break;
		}
	}

	public void cry() {
		switch (mmState) {
			case HAPPY:
				System.out.println("喜极而泣");
				break;
			case SAD:
				System.out.println("伤心的哭");
				break;
			default:
				break;
		}
	}

	public void say() {
		switch (mmState) {
			case HAPPY:
				System.out.println("有趣的说话");
				break;
			case SAD:
				System.out.println("脾气不好的说话");
				break;
			default:
				break;
		}
	}
}


