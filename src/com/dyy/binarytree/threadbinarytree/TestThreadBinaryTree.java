package com.dyy.binarytree.threadbinarytree;

public class TestThreadBinaryTree {
	public static void main(String[] args) {
		//创建一棵树
		ThreadBinaryTree binTree = new ThreadBinaryTree();
		//创建一个根节点
		ThreadTreeNode root = new ThreadTreeNode(1);
		//将根节点赋值给树
		binTree.setRoot(root);
		//创建两个节点
		ThreadTreeNode rootL = new ThreadTreeNode(2);
		ThreadTreeNode rootR = new ThreadTreeNode(3);
		//将两个节点赋给根节点的左右孩子
		root.setLeftNode(rootL);
		root.setRightNode(rootR);
		//为第二层的左节点创建两个孩子
		rootL.setLeftNode(new ThreadTreeNode(4));
		rootL.setRightNode(new ThreadTreeNode(5));
		//为第二层的右节点创建两个孩子
		rootR.setLeftNode(new ThreadTreeNode(6));
		rootR.setRightNode(new ThreadTreeNode(7));
		//前序遍历
		//binTree.frontShow();
		//System.out.println("++++++++++++++++++++++++++++");
		//中序遍历
		//binTree.midShow();
		//System.out.println("++++++++++++++++++++++++++++");
		//后序遍历
		//binTree.afterShow();
		//System.out.println("++++++++++++++++++++++++++++");
		//前序查找
		//ThreadTreeNode target = binTree.frontSearch(8);
		//System.out.println(target);
		//删除节点
		//binTree.delete(6);
		
		binTree.midShow();
		binTree.threadNodes();
		binTree.threadIterate();
	}
}
