package com.ahead.command.cor;

import com.ahead.command.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class Main {
	List<Command> commands = new ArrayList<>();

	public Main add(Command command) {
		commands.add(command);
		return this;
	}

	public void doit() {
		for (Command command : commands) {
			command.doit();
		}
	}

	public void undo() {
		for (int i = commands.size() - 1; i >= 0; i--) {
			commands.get(i).undo();
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		Content content = new Content();

		System.out.println(content.msg);

		main.add(new InsertCommand(content)).add(new CopyCommand(content)).add(new DeleteCommand(content));
		main.doit();

		System.out.println(content.msg);

		main.undo();

		System.out.println(content.msg);
	}
}
