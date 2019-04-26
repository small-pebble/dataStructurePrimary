package com.dyy.huffmantree;

public class Node implements Comparable<Node>{
	int value;
	Node leftNode;
	Node rightNode;
	
	public Node(int value){
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return -(this.value-o.value);
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
}
