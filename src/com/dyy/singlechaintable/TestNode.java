package com.dyy.singlechaintable;

public class TestNode {
	public static void main(String[] args) {
		//创建节点
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		//追加节点
		n1.append(n2).append(n3).append(n4);
		//取出下一个节点的数据
		System.out.println(n1.next().next().next().getData());
		//判断节点是否为最后一个
		System.out.println(n1.next().next().isLast());
		//显示该节点后的所有节点信息
		n1.show();
		/*n3.removeNext();
		n1.show();*/
		//插入一个新节点
		n2.insertAfter(new Node(5));
		n1.show();
	}
}
