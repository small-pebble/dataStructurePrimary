package com.dyy.doublecirclechaintable;

public class DoubleNode {
	//上一个节点
	DoubleNode pre = this;
	//下一个节点
	DoubleNode next = this;
	//节点数据
	int data;
	//构造函数
	public DoubleNode(int data){
		this.data = data;
	}
	
	//增加节点
	public void after(DoubleNode doubleNode){
		//取出下一个节点作为下下一个节点
		DoubleNode nextnextNode = this.next;
		//新节点作为当前节点的下一个节点
		this.next = doubleNode;
		//新节点的前一个节点为当前节点
		doubleNode.pre = this;
		//新节点的下一个节点为原来的下一个节点
		doubleNode.next = nextnextNode;
		//原来的下一个节点的前一个节点为新节点
		nextnextNode.pre = doubleNode;
	}
	//获取下一个节点
	public DoubleNode next(){
		return this.next;
	}
	//获取上一个节点
	public DoubleNode pre(){
		return this.pre;
	}
	//获得数据
	public int getData(){
		return this.data;
	}
}
