package com.dyy.sort;

import java.util.Arrays;

import com.dyy.queue.MyQueue;

public class RadixQueueSort {
	
	public static void main(String[] args) {
		int[] arr = {233,345,45,3,876,8,76,546,98,9,12,809};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void radixSort(int[] arr){
		//求出最大值的位数
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(max<arr[i])
				max = arr[i];
		}
		int len = (max+"").length();
		//开辟队列数组存数据
		MyQueue[] temp = new MyQueue[10];
		//为队列赋值
		for(int i = 0;i<temp.length;i++){
			temp[i] = new MyQueue();
		}
		for(int n=1;n<Math.pow(10,len);n=n*10){
			for(int i=0;i<arr.length;i++){
				//对每个数取余数
				int remainder = (arr[i]/n)%10;
				temp[remainder].add(arr[i]);
			}
			int index = 0;
			for(int i=0;i<10;i++){
				while(!temp[i].isEmpty()){
					arr[index++] = temp[i].poll();
				}
			}
		}
	} 
}
