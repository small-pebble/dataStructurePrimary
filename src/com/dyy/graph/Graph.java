package com.dyy.graph;

import com.dyy.stack.MyStack;

public class Graph {
	private Vertex[] vertexs;
	private int currentSize;
	public int[][] adjMat;
	private MyStack stack = new MyStack();
	//当前遍历的下标
	private int currentIndex;
	
	public Graph(int size){
		vertexs = new Vertex[size];
		adjMat = new int[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(i==j){
					adjMat[i][j] = 1;
				}
			}
		}
	}
	
	public void addVertex(Vertex v){
		vertexs[currentSize++] = v;
	}
	
	public void addEdge(String v1,String v2){
		int index1 = 0;
		for(int i=0;i<vertexs.length;i++){
			if(vertexs[i].getValuex().equals(v1)){
				index1 = i;
				break;
			}
		}
		
		int index2 = 0;
		for(int i=0;i<vertexs.length;i++){
			if(vertexs[i].getValuex().equals(v2)){
				index2 = i;
				break;
			}
		}
		adjMat[index1][index2] = 1;
		adjMat[index2][index1] = 1;
	} 
	
}
