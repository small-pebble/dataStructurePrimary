package com.dyy.binarytree.balancedbinarytree;

public class TestBinarySortTree {
	public static void main(String[] args) {
		//int[] arr = new int[]{8,9,6,7,5,4};
		//int[] arr = new int[]{2,1,4,3,5,6};
		int[] arr = new int[]{8,9,5,4,6,7};
		BinarySortTree bst = new BinarySortTree();
		for(int i:arr){
			Node iNode = new Node(i);
			bst.add(iNode);
		}
		//查看高度
		bst.show();
		System.out.println(bst.root.height());
		System.out.println(bst.root.getValue());
	}
}
