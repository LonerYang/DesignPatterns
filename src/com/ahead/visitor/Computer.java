package com.ahead.visitor;


/**
 * 用于编译器上
 * 被参观的类是不能变的
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class Computer {
	ComputerPart cpu = new CPU();
	ComputerPart board = new Board();
	ComputerPart memory = new Memory();

	public void accept(Visitor visitor) {
		this.cpu.accept(visitor);
		this.board.accept(visitor);
		this.memory.accept(visitor);
	}

	public static void main(String[] args) {
		StudentVisitor visitor = new StudentVisitor();
		new Computer().accept(visitor);
		System.out.println(visitor.total);
	}
}

abstract class ComputerPart {
	abstract void accept(Visitor visitor);

	abstract double getPrice();
}

class CPU extends ComputerPart {

	@Override
	void accept(Visitor visitor) {
		visitor.visitorCPU(this);
	}

	@Override
	double getPrice() {
		return 200;
	}
}

class Board extends ComputerPart {

	@Override
	void accept(Visitor visitor) {
		visitor.visitorBoard(this);
	}

	@Override
	double getPrice() {
		return 50;
	}
}

class Memory extends ComputerPart {

	@Override
	void accept(Visitor visitor) {
		visitor.visitorMemory(this);
	}

	@Override
	double getPrice() {
		return 100;
	}
}
interface Visitor {
	void visitorCPU(CPU cpu);

	void visitorBoard(Board board);

	void visitorMemory(Memory memory);
}

class StudentVisitor implements Visitor {

	double total = 0.0;

	@Override
	public void visitorCPU(CPU cpu) {
		total += cpu.getPrice() * 0.5;
	}

	@Override
	public void visitorBoard(Board board) {
		total += board.getPrice() * 0.5;
	}

	@Override
	public void visitorMemory(Memory memory) {
		total += memory.getPrice() * 0.5;
	}
}

