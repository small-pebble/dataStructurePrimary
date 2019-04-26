package com.dyy.stack;

public class TestMyStack {
	public static void main(String[] args) {
		MyStack ms = new MyStack();
		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.push(4);
		ms.push(5);
		System.out.println(ms.pop());
		System.out.println(ms.peek());
		System.out.println(ms.isEmpty());
		
	}
}
