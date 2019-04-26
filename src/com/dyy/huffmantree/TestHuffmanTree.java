package com.dyy.huffmantree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestHuffmanTree {
	public static void main(String[] args) {
		int[] arr = new int[]{3,7,8,29,5,11,23,14};
		Node node = createHuffmanTree(arr);
		System.out.println(node);
	}
	
	
	//创建哈夫曼树
	public static Node createHuffmanTree(int[] arr){
		//先使用数组中所有元素创建若干二叉树（只有一个节点）
		List<Node> nodes = new ArrayList();
		for(int value:arr){
			nodes.add(new Node(value));
		}
		//循环处理，当只有一个节点时停止处理
		while(nodes.size()>1){
			//排序
			Collections.sort(nodes);
			//取出权值最小的两个二叉树
			Node left = nodes.get(nodes.size()-1);
			Node right = nodes.get(nodes.size()-2);
			//创建一个新的二叉树
			Node newNode = new Node(left.value+right.value);
			newNode.leftNode = left;
			newNode.rightNode = right;
			//将原来最小的两个二叉树移除
			nodes.remove(left);
			nodes.remove(right);
			//将新二叉树放入集合中
			nodes.add(newNode);
			
		}
		return nodes.get(0);
	}
}
