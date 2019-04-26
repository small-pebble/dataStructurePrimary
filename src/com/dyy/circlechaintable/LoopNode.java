package com.dyy.circlechaintable;

//一个节点
public class LoopNode {
	//节点的内容
	int data;
	
	//下一个节点
	LoopNode next = this;
	
	public LoopNode(int data){
		this.data = data;
	}
	
	//在该节点后插入一个节点
	public void insertAfter(LoopNode loopNode){
		//取出下一个节点作为下下一个节点
		LoopNode nextnextNode = this.next;
		//将新节点加到本节点后
		this.next = loopNode;
		//将下下一个节点加到新节点后
		loopNode.next = nextnextNode;
	}
	
	
	//删除下一个节点
	public void removeNext(){
		//取出下下一个节点
		LoopNode nodeNext = next.next;
		//把下下一个节点赋给这一个节点
		this.next = nodeNext;
	}
	
	//获取下一个节点
	public LoopNode next(){
		return this.next;
	}
	
	//获得节点的数据
	public int getData(){
		return this.data;
	}
	
}
