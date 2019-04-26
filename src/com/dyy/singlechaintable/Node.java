package com.dyy.singlechaintable;

//一个节点
public class Node {
	//节点的内容
	int data;
	
	//下一个节点
	Node next;
	
	public Node(int data){
		this.data = data;
	}
	
	//为节点追加节点
	public Node append(Node node){
		//当前节点
		Node currentNode = this;
		
		//向后循环找
		while(true){
			//取出下一个节点
			Node nextNode = currentNode.next;
			//如果下一个节点为null,当前节点已经是最后一个节点
			if(nextNode==null){
				break;
			}
			currentNode = nextNode;
		}
		
		currentNode.next = node;
		return this;
	}
	
	//在该节点后插入一个节点
	public void insertAfter(Node node){
		//取出下一个节点作为下下一个节点
		Node nextnextNode = this.next;
		//将新节点加到本节点后
		this.next = node;
		//将下下一个节点加到新节点后
		node.next = nextnextNode;
	}
	
	//显示该节点后面的所有节点信息
	public void show(){
		Node currentNode = this;
		while(true){
			System.out.print(currentNode.data+" ");
			//取出下一个节点
			currentNode = currentNode.next();
			//如果是最后一个节点
			if(currentNode==null){
				break;
			}
		}
		System.out.println();
	}
	
	//删除下一个节点
	public void removeNext(){
		//取出下下一个节点
		Node nodeNext = next.next;
		//把下下一个节点赋给这一个节点
		this.next = nodeNext;
	}
	
	//获取下一个节点
	public Node next(){
		return this.next;
	}
	
	//获得节点的数据
	public int getData(){
		return this.data;
	}
	
	//当前节点是否是最后一个节点
	public boolean isLast(){
		return next==null;
	}
}
