package com.dyy.array;

public class LinearSearch {
	public static void main(String[] args) {
		//目标数组
		int[] arr = new int[] {2,3,14,5,6,23,65,8,7,98};
		//目标元素
		int target = 14;
		//目标元素所在下标
		int index = -1;
		//遍历数组
		for(int i=0;i<arr.length;i++){
			if(target==arr[i]){
				index = i;
				break;
			}
		}
		System.out.println(index);
	}
}
