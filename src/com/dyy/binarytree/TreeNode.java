package com.dyy.binarytree;

public class TreeNode {
	
	int value;
	
	TreeNode leftNode;
	TreeNode rightNode;
	
	public TreeNode(int value){
		this.value = value;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	//前序遍历
	public void frontShow() {
		System.out.println(value);
		if(leftNode!=null)
			leftNode.frontShow();
		if(rightNode!=null)
			rightNode.frontShow();
	}

	public void midShow() {
		if(leftNode!=null)
			leftNode.midShow();
		System.out.println(value);
		if(rightNode!=null)
			rightNode.midShow();
	}

	public void afterShow() {
		if(leftNode!=null)
			leftNode.afterShow();
		if(rightNode!=null)
			rightNode.afterShow();
		System.out.println(value);
	}
	
	//	前序查找
	public TreeNode frontSearch(int value) {
		TreeNode target = null;
		if(this.value==value){
			return this;
		}else{
			if(leftNode!=null)
				target = leftNode.frontSearch(value);
			if(target!=null)
				return target;
			if(rightNode!=null)
				target = rightNode.frontSearch(value);
		}
		return target;
	}

	//删除节点
	public void delete(int i) {
		TreeNode parent = this;
		if(parent.leftNode!=null && parent.leftNode.value==i){
				parent.leftNode = null;
				return;
		}
		if(parent.rightNode!=null && parent.rightNode.value==i){
				parent.rightNode = null;
				return;
		}
		parent = leftNode;
		if(parent != null){
			parent.delete(i);
		}
		parent = rightNode;
		if(parent != null){
			parent.delete(i);
		}
	}
}
