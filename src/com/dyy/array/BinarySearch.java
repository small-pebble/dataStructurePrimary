package com.dyy.array;

public class BinarySearch {
	public static void main(String[] args) {
		//目标数组
		int[] arr = new int[] {2,3,5,7,9,12,45,67,78,89,90};
		//目标元素
		int target = 11;
		//查找的起始索引
		int begin = 0;
		//查找的结束索引
		int end = arr.length;
		//查找的二分索引
		int mid = (begin+end)/2;
		//目标元素的索引
		int index = -1;
		//循环查找元素
		while(true){
			
			//没有该元素
			if(begin>end){
				break;
			}
			
			//被查找的元素正好是中间的元素
			if(target==arr[mid]){
				index = mid;
				break;
			}else{
				//被查找的元素不是中间元素
				if(target < arr[mid]){
					end = mid-1;
				}else{
					begin = mid+1;
				}
				mid = (begin+end)/2;
			}
		}
		System.out.println(index);
	}
}
