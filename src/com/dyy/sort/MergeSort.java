package com.dyy.sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11,13,15,2,4,6,8,10};
		System.out.println(Arrays.toString(arr));
		merge(arr,0,7,12);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr,int low,int high){
		int middle = (low+high)/2;
		if(low<high){
			mergeSort(arr,low,middle);
			mergeSort(arr,middle+1,high);
			merge(arr,low,middle,high);
		}
	}
	
	public static void merge(int[] arr,int low,int middle,int high){
		int[] temp = new int[high-low+1];
		int index = 0;
		int i=low, j=middle+1;
		while(i<=middle && j<=high){
			if(arr[i]<=arr[j]){
				temp[index++] = arr[i++];
			}else{
				temp[index++] = arr[j++];
			}
		}
		while(i<=middle){
			temp[index++] = arr[i++];
		}
		while(j<=high){
			temp[index++] = arr[j++];
		}
		for(index=0;index<temp.length;){
			arr[low++] = temp[index++];
		}
		/*for(int a:arr){
			System.out.println(a);
		}*/
	}
}
