package com.dyy.binarytree.binarysorttree;

import org.junit.Test;

public class Node {
	private int value;
	private Node leftNode;
	private Node rightNode;
	
	public Node(int value){
		this.value = value;
	}
	
	public void add(Node node){
		if(this.value>node.value){
			if(this.leftNode==null){
				this.leftNode = node;
			}else{
				this.leftNode.add(node);
			}
		}else{
			if(this.rightNode==null){
				this.rightNode = node;
			}else{
				this.rightNode.add(node);
			}
		}
	}

	//相当于中序遍历
	public void show(Node node) {
		if(node==null){
			return;
		}
		show(node.leftNode);
		System.out.println(node.value);
		show(node.rightNode);
		
	}

	
	//查找节点
	public Node search(int value) {
		if(this.value==value){
			return this;
		}else if(this.value>value){
			if(this.leftNode==null){
				return null;
			}
			return this.leftNode.search(value);
		}else{
			if(this.rightNode==null){
				return null;
			}
			return this.rightNode.search(value);
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	//删除节点
	public void delete(int value) {
		//找到这个节点
		Node target = search(value);
		if(target==null){
			return;
		}
		//找到这个节点的父节点
		Node parent = findParent(value);
		//删除叶子节点
		if(target.leftNode==null&&target.rightNode==null){
			if (parent.leftNode != null && parent.leftNode.value == value) {
				parent.leftNode = null;
			} else {
				parent.rightNode = null;
			}
		//删除有两个子节点的节点
		}else if(target.leftNode!=null && target.rightNode!=null){
			//删除右子树中值最小的节点，并返回值
			int min = deleteMin(target.rightNode);
			//将返回的值赋给要删除的节点
			target.value = min;
		//删除有一个节点的子节点
		}else{
			//如果target有左孩子
			if(target.leftNode!=null){
				//如果target为parent的左孩子
				if(parent.leftNode.value==value){
					parent.leftNode = target.leftNode;
				//如果target为parent的右孩子
				}else{
					parent.rightNode = target.leftNode;
				}
			//如果target有右孩子
			}else{
				//如果target为parent的左孩子
				if(parent.leftNode.value==value){
					parent.leftNode = target.rightNode;
				//如果target为parent的右孩子
				}else{
					parent.rightNode = target.rightNode;
				}
			}
		}
	}
	private int deleteMin(Node node) {
		Node target = node;
		while(target.leftNode!=null){
			target = target.leftNode;
		}
		delete(target.value);
		return target.value;
	}

	private Node findParent(int value) {
		if((this.leftNode!=null&&this.leftNode.value==value)||(this.rightNode!=null&&this.rightNode.value==value)){
			return this;
		}else if(this.leftNode!=null || this.rightNode!=null){
			if(this.leftNode!=null && this.value>value){
				return this.leftNode.findParent(value);
			}else if(this.rightNode!=null && this.value<=value){
				return this.rightNode.findParent(value);
			}
		}
		return null;
	}
	
	
}
