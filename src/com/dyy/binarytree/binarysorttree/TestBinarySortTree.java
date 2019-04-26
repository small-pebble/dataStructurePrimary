package com.dyy.binarytree.binarysorttree;

public class TestBinarySortTree {
	public static void main(String[] args) {
		int[] arr = new int[]{7,3,10,12,5,1,9};
		BinarySortTree bst = new BinarySortTree();
		for(int i:arr){
			Node iNode = new Node(i);
			bst.add(iNode);
		}
		bst.show();
		//System.out.println(bst.search(10));
		//System.out.println(bst.search(20));
		System.out.println("----------------------------");
		//删除叶子节点
		/*bst.delete(1);
		bst.show();
		System.out.println("-----------");
		bst.delete(3);
		bst.show();*/
		bst.delete(3);
		bst.show();
	}
}
