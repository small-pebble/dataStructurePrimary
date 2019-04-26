package com.dyy.binarytree;

public class BinaryTree {
	
	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void frontShow() {
		if(root!=null){
			root.frontShow();
		}
	}

	public void midShow() {
		if(root!=null){
			root.midShow();
		}
	}

	public void afterShow() {
		if(root!=null){
			root.afterShow();
		}
	}

	public TreeNode frontSearch(int value) {
		return root.frontSearch(value);
	}

	public void delete(int i) {
		if(root.value==i){
			root = null;
			return;
		}else{
			root.delete(i);
		}
	}
	
}
