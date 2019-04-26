package com.dyy.sort;

//交换类排序
public class ExchangeSort {
	public static void main(String[] args) {
		int[] arr = new int[] {12,43,2,3,6,4,23,65,5,9,8,45,66,55,77,88,3,2,1,5,0,9,8,46,15,35,79};
		for(int a:arr){
			System.out.print(a+" ");
		}
		System.out.println();
		//bubbleSort(arr);
		quickSort(arr,0,arr.length-1);
		for(int a:arr){
			System.out.print(a+" ");
		}
	}
	
	//快速排序
	public static void quickSort(int[] arr,int low,int high){
		if(low<high){
			int left = low, right = high;
			int target = arr[left],temp;
			while(left<right){
				while(left<right && arr[right]>=target) right--;
				arr[left] = arr[right];
				while(left<right && arr[left]<=target) left++;
				arr[right] = arr[left];
			}
			arr[right] = target;
			quickSort(arr,low,right-1);
			quickSort(arr,right+1,high);
		}
	}
	
	
	//冒泡排序
	public static void bubbleSort(int[] arr){
		int i,j,temp;
		boolean flag = true;
		for(i=0;i<arr.length-1;i++){
			for(j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			if(flag) return;
		}
	}
	
}
