package com.dyy.stack;

public class MyStack {
		//栈的底层用数组存储
		int[] elements;
		
		public MyStack(){
			elements = new int[0];
		};
		
		//压入元素
		public void push(int element){
			//创建一个新数组
			int[] newArr = new int[elements.length+1];
			for(int i=0;i<elements.length;i++){
				newArr[i] = elements[i];
			}
			newArr[elements.length] = element;
			elements = newArr;
		}
		
		//取出栈顶元素
		public int pop(){
			//栈中没有元素
			if(elements.length==0){
				throw new RuntimeException("stack is empty");
			}
			
			//取出最后一个元素
			int element = elements[elements.length-1];
			//创建一个新数组
			int[] newArr = new int[elements.length-1];
			for(int i=0;i<elements.length-1;i++){
				newArr[i] = elements[i];
			}
			elements = newArr;
			return element;
		}
		
		//查看栈顶元素
		public int peek(){
			return elements[elements.length-1];
		}
		
		//判断栈是否为空
		public boolean isEmpty(){
			return elements.length==0;
		}
	}
	

