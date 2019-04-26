package com.dyy.binarytree;

public class ArrayBinaryTree {
	int[] data;
	public ArrayBinaryTree(int[] data ){
		this.data = data;
	};
	
	public void frontShow(){
		this.frontShow(0);
	}
	
	public void frontShow(int index){
		if(data==null || data.length==0)
			return;
		
		System.out.println(data[index]);
		if(2*index+1<data.length){
			this.frontShow(2*index+1);
		}
		if(2*index+2<data.length){
			this.frontShow(2*index+2);
		}
	}
}
