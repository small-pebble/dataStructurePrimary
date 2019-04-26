package com.dyy.sort;

import java.util.Arrays;

public class RadixSort {
	
	public static void main(String[] args) {
		int[] arr = {233,345,45,3,876,8,76,546,98,9,12,809};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void radixSort(int[] arr){
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(max<arr[i])
				max = arr[i];
		}
		int len = (max+"").length();
		int[][] container = new int[10][arr.length];
		int[] count = new int[10];
		for(int n=1;n<1000;n=n*10){
			for(int i=0;i<arr.length;i++){
				//对每个数取余数
				int remainder = (arr[i]/n)%10;
				container[remainder][count[remainder]++] = arr[i];
			}
			for(int i=0,k=0,r=0;i<arr.length;i++){
				if(k<count[r])
					arr[i] = container[r][k++];
				else{
					k=0;r++;i--;
				}
			}
			Arrays.fill(count, 0);
		}
	} 
}
