package com.dyy.sort;

public class InsertSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {12,43,2,3,6,4,23,65,5,9,8,45,66,55,77,88,3,2,1,5,0,9,8,46,15,35,79};
		for(int a:arr){
			System.out.print(a+" ");
		}
		System.out.println();
		shellSort(arr);
		for(int a:arr){
			System.out.print(a+" ");
		}
	}
	
	//直接插入排序
	public static void straightInsertSort(int[] arr){
		int i,j,temp;
		for(i=1;i<arr.length;i++){
			if(arr[i]<arr[i-1]){
				temp = arr[i];
				for (j=i-1; j>=0 && arr[j]>temp ;j--) {
					arr[j+1] = arr[j];
				}
				arr[j+1] = temp;	
			}
		}
	}
	
	//希尔排序
	public static void shellSort(int[] arr){
		int i,j,temp,d;
		for(d=arr.length/2;d>0;d=d/2){
			for(i=d;i<arr.length;i++){
				if(arr[i]<arr[i-d]){
					temp = arr[i];
					for(j=i-d;j>=0 && arr[j]>temp;j -= d){
						arr[j+d] = arr[j];
					}
					arr[j+d] = temp;
				}
			}
		}
	}
}
