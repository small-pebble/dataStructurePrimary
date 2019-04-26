package com.dyy.sort;

public class SelectSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {12,43,2,3,6,4,23,65,5,9,8,45,66,55,77,88,3,2,1,5,0,9,8,46,15,35,79};
		for(int a:arr){
			System.out.print(a+" ");
		}
		System.out.println();
		simpleSelectSort(arr);
		for(int a:arr){
			System.out.print(a+" ");
		}
	}
	
	public static void simpleSelectSort(int[] arr){
		int temp,i,j;
		for(i=0;i<arr.length;i++){
			int min = i;
			for(j=i+1;j<arr.length;j++){
				if(arr[min]>arr[j]) min = j;
			}
			if(min != i){
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	} 
}
