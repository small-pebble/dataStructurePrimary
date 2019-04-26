package com.dyy.binarytree.threadbinarytree;

public class ThreadBinaryTree {
	
	ThreadTreeNode root;
	//前驱结点
	ThreadTreeNode pre;

	public ThreadTreeNode getRoot() {
		return root;
	}

	public void setRoot(ThreadTreeNode root) {
		this.root = root;
	}
	
	//遍历线索二叉树
	public void threadIterate(){
		//临时存储当前节点
		ThreadTreeNode node = root;
		while(node!=null){
			//循环找到最开始的节点
			while(node.leftType==0){
				node = node.leftNode;
			}
			//打印当前节点的值
			System.out.println(node.value);
			//如果当前节点指向的后继节点还有后继节点
			while(node.rightType==1){
				node = node.rightNode;
				System.out.println(node.value);
			}
			//替换遍历的节点
			node = node.rightNode;
		}
	}

	//线索化二叉树
	public void threadNodes(){
		threadNodes(root);
	}
	public void threadNodes(ThreadTreeNode node){
		//当前节点如果未null，直接返回
		if(node==null){
			return;
		}
		//处理左子树
		threadNodes(node.leftNode);
		//处理前驱结点
		if(node.leftNode==null){
			//让当前节点的左指针指向前驱节点
			node.leftNode = pre;
			node.leftType = 1;
		}
		//处理前驱节点的右指针
		if(pre!=null && pre.rightNode==null){
			//让前驱结点的右指针指向当前节点
			pre.rightNode = node;
			pre.rightType = 1;
		}
		
		//令当前节点的为下一个节点的前驱结点
		pre = node;
		
		//处理右子树
		threadNodes(node.rightNode);
	}
	
	//前序遍历
	public void frontShow() {
		if(root!=null){
			root.frontShow();
		}
	}

	//中序遍历
	public void midShow() {
		if(root!=null){
			root.midShow();
		}
	}

	//后序遍历
	public void afterShow() {
		if(root!=null){
			root.afterShow();
		}
	}

	//前序查找
	public ThreadTreeNode frontSearch(int value) {
		return root.frontSearch(value);
	}

	//删除节点
	public void delete(int i) {
		if(root.value==i){
			root = null;
			return;
		}else{
			root.delete(i);
		}
	}
	
}
