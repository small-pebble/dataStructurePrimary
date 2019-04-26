package com.dyy.huffmantree.huffmancode;

public class Node implements Comparable<Node>{
	Byte value;
	Integer weight;
	Node leftNode;
	Node rightNode;
	
	public Node(Byte value,Integer weight){
		this.value = value;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Node o) {
		return o.weight-this.weight;
	}
	
	
}
