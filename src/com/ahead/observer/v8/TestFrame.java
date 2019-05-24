package com.ahead.observer.v8;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Java中的AWT组件用到的观察者模式
 * @author Yang
 * @version 1.0
 * @time 2019/5/20
 */
public class TestFrame extends Frame {

	public void lunch() {
		java.awt.Button button = new java.awt.Button("press me");
		button.addActionListener((e) -> ((java.awt.Button)e.getSource()).setLabel("Yang"));
		this.add(button);
		this.pack();
		this.setLocation(500, 300);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestFrame().lunch();
	}
}
