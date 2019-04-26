package com.dyy.queue;

public class MyQueue {
	int[] elements;
	
	public MyQueue(){
		elements = new int[0];
	}
	
	//入队
	public void add(int element){
		//创建一个新数组
		int[] newArr = new int[elements.length+1];
		for(int i=0;i<elements.length;i++){
			newArr[i] = elements[i];
		}
		newArr[elements.length] = element;
		elements = newArr;
	}
	
	//出队
	public int poll(){
		//把数组中的第0个元素取出来
		int element = elements[0];
		//创建一个新数组
		int[] newArr = new int[elements.length-1];
		for(int i=0;i<elements.length-1;i++){
			newArr[i] = elements[i+1];
		}
		elements = newArr;
		return element;
	}
	//判断是否为空
	public boolean isEmpty(){
		return elements.length==0;
	}
}
