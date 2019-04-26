package com.dyy.binarytree;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = new int[] {9,6,8,7,0,1,10,4,2};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void heapSort(int[] arr){
		int start = (arr.length-2)/2;
		for(int i = start;i>=0;i--){
			maxHeap(arr,arr.length,i);
		}
		for(int i = arr.length-1;i>0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeap(arr,i,0);
		}
	}
	
	public static void maxHeap(int[] arr,int size,int index){
		//将该节点与两个子节点对比，找出最大值
		//左右节点的最大值
		int childMax = 0;
		if((index*2+1)<size)
			childMax = arr[index*2+1];
		if((index*2+2)<size)
			childMax = Math.max(arr[index*2+1], arr[index*2+2]);
		int max = index;
		if(arr[index]<childMax){
			int temp = arr[index];
			arr[index] = childMax;
			if((index*2+1)<size && arr[index*2+1]==childMax){
				arr[index*2+1] = temp;
				max = index*2+1;
			}
			if((index*2+2)<size && arr[index*2+2]==childMax){
				arr[index*2+2] = temp;
				max = index*2+2;
			}
			//交换后破坏了之前的大顶堆，从max处再重新调整位置
			maxHeap(arr,size,max);
		}
	}
}
