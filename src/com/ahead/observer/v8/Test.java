package com.ahead.observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟Java中Button组件按下去的事件
 * @author Yang
 * @version 1.0
 * @time 2019/5/20
 */
public class Test {
	public static void main(String[] args) {
		Button button = new Button();
		button.addActionListener(new MyActionListener());
		button.buttonPressed();
	}
}
class ActionEvent {
	long when;
	Object source;

	public ActionEvent(long when, Object source) {
		this.when = when;
		this.source = source;
	}

	public long getWhen() {
		return when;
	}

	public Object getSource() {
		return source;
	}
}

interface ActionListener {
	void actionPerformed(ActionEvent event);
}

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("this button is pressed");
	}
}

class Button {

	List<ActionListener> actionListeners = new ArrayList<>();

	public void buttonPressed() {
		ActionEvent e = new ActionEvent(System.currentTimeMillis(),this);
		if (!actionListeners.isEmpty()) {
			for (int i = 0; i < actionListeners.size(); i++) {
				ActionListener l = actionListeners.get(i);
				l.actionPerformed(e);
			}
		}
	}

	public void addActionListener(ActionListener l) {
		actionListeners.add(l);
	}

}
