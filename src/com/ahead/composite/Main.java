package com.ahead.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：一般用于树形结构
 *
 * @author Yang
 * @version 1.0
 * @time 2019/5/20
 */
abstract class Node {
	private String content;

	public Node(String content) {
		this.content = content;
	}
	public void print() {
		System.out.println(content);
	}
}

/**
 * 叶子节点：无子节点
 */
class LeafNode extends Node {
	private String content;

	public LeafNode(String content) {
		super(content);
		this.content = content;
	}

}

/**
 * 分支节点：可能有分支节点和叶子节点
 */
class BranchNode extends Node {
	private String content;

	private List<Node> nodes = new ArrayList<>();

	public BranchNode(String content) {
		super(content);
	}

	public void add(Node node) {
		nodes.add(node);
	}

	public List<Node> getNodes() {
		return nodes;
	}
}

public class Main {
	public static void main(String[] args) {
		BranchNode root = new BranchNode("root");
		LeafNode classpath = new LeafNode(".classpath");
		BranchNode src = new BranchNode("src");
		BranchNode comAheadComposite = new BranchNode("com.ahead.composite");
		LeafNode Main = new LeafNode("Main.java");

		root.add(classpath);

		comAheadComposite.add(Main);
		src.add(comAheadComposite);
		root.add(src);

		show(root, 0);
	}

	/**
	 * 显示树形结构
	 * @param node 要打印的节点
	 * @param hierarchy 属于哪层
	 */
	static void show(Node node, int hierarchy) {
		for (int i = 0; i < hierarchy; i++) {
			System.out.print("-- ");
		}
		node.print();
		if (node instanceof BranchNode) {
			for (Node n : ((BranchNode)node).getNodes()) {
				show(n, hierarchy + 1);
			}
		}
	}
}

