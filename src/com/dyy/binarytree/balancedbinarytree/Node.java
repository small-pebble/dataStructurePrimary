package com.dyy.binarytree.balancedbinarytree;

public class Node {
	private int value;
	private Node leftNode;
	private Node rightNode;
	
	
	public Node(int value){
		this.value = value;
	}
	
	public void add(Node node){
		if(this.value>node.value){
			if(this.leftNode==null){
				this.leftNode = node;
			}else{
				this.leftNode.add(node);
			}
		}else{
			if(this.rightNode==null){
				this.rightNode = node;
			}else{
				this.rightNode.add(node);
			}
		}
		//判断节点是否平衡
		//进行右旋转
		if(leftHeight()-rightHeight()>=2){
			//双旋转
			if(leftNode!=null && leftNode.leftHeight()<leftNode.rightHeight()){
				leftNode.leftRotate();
				rightRotate();
			//单旋转
			}else{
				rightRotate();
			}
		//进行左旋转
		}
		if(leftHeight()-rightHeight()<=-2){
			//双旋转
			if(rightNode!=null && rightNode.rightHeight()<rightNode.leftHeight()){
				rightNode.rightRotate();
				leftRotate();
			}else{
				leftRotate();
			}
		}
	}

	private void leftRotate() {
		Node newLeft = new Node(value);
		newLeft.leftNode = leftNode;
		newLeft.rightNode = rightNode.leftNode;
		this.value = rightNode.value;
		rightNode = rightNode.rightNode;
		leftNode = newLeft;
	}

	private void rightRotate() {
		//复制该节点
		Node newRight = new Node(value);
		//将该节点的右子树赋给新节点的右子树
		newRight.rightNode = rightNode;
		//将该节点左子树的右子树赋给新节点的左子树
		newRight.leftNode = leftNode.rightNode; 
		//将该节点的值变成左节点的值
		this.value = leftNode.value;
		//将该节点左指针指向左孩子的左指针
		leftNode = leftNode.leftNode;
		//将该节点的右指针指向新的节点
		rightNode = newRight;
	}

	private int rightHeight() {
		if(rightNode==null){
			return 0;
		}
		return rightNode.height();
	}

	private int leftHeight() {
		if(leftNode==null)
			return 0;
		return leftNode.height();
	}

	public int height() {
		return Math.max(leftNode==null?0:leftHeight(),rightNode==null?0:rightHeight())+1;
	}

	//相当于中序遍历
	public void show(Node node) {
		if(node==null){
			return;
		}
		show(node.leftNode);
		System.out.println(node.value);
		show(node.rightNode);
		
	}

	
	//查找节点
	public Node search(int value) {
		if(this.value==value){
			return this;
		}else if(this.value>value){
			if(this.leftNode==null){
				return null;
			}
			return this.leftNode.search(value);
		}else{
			if(this.rightNode==null){
				return null;
			}
			return this.rightNode.search(value);
		}
	}

	//删除节点
	public void delete(int value) {
		//找到这个节点
		Node target = search(value);
		if(target==null){
			return;
		}
		//找到这个节点的父节点
		Node parent = findParent(value);
		//删除叶子节点
		if(target.leftNode==null&&target.rightNode==null){
			if (parent.leftNode != null && parent.leftNode.value == value) {
				parent.leftNode = null;
			} else {
				parent.rightNode = null;
			}
		//删除有两个子节点的节点
		}else if(target.leftNode!=null && target.rightNode!=null){
			//删除右子树中值最小的节点，并返回值
			int min = deleteMin(target.rightNode);
			//将返回的值赋给要删除的节点
			target.value = min;
		//删除有一个节点的子节点
		}else{
			//如果target有左孩子
			if(target.leftNode!=null){
				//如果target为parent的左孩子
				if(parent.leftNode.value==value){
					parent.leftNode = target.leftNode;
				//如果target为parent的右孩子
				}else{
					parent.rightNode = target.leftNode;
				}
			//如果target有右孩子
			}else{
				//如果target为parent的左孩子
				if(parent.leftNode.value==value){
					parent.leftNode = target.rightNode;
				//如果target为parent的右孩子
				}else{
					parent.rightNode = target.rightNode;
				}
			}
		}
	}
	private int deleteMin(Node node) {
		Node target = node;
		while(target.leftNode!=null){
			target = target.leftNode;
		}
		delete(target.value);
		return target.value;
	}

	private Node findParent(int value) {
		if((this.leftNode!=null&&this.leftNode.value==value)||(this.rightNode!=null&&this.rightNode.value==value)){
			return this;
		}else if(this.leftNode!=null || this.rightNode!=null){
			if(this.leftNode!=null && this.value>value){
				return this.leftNode.findParent(value);
			}else if(this.rightNode!=null && this.value<=value){
				return this.rightNode.findParent(value);
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

}
