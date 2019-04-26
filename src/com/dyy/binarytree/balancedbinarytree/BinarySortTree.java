package com.dyy.binarytree.balancedbinarytree;

public class BinarySortTree {
	Node root;
	
	public void add(Node node){
		if(root==null){
			root = node;
		}else{
			root.add(node);
		}
	}

	public void show() {
		if(root==null){
			return;
		}else{
			root.show(root);
		}
	}

	public Node search(int value) {
		if(root==null){
			return null;
		}else{
			return root.search(value);
		}
	}

	//删除节点
	public void delete(int value) {
		if(root==null){
			return;
		}
		root.delete(value);
	}
}
