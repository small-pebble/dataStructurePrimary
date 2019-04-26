package com.dyy.graph;

import java.util.Arrays;

public class TestGraph {
	public static void main(String[] args) {
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");

		Graph g = new Graph(5);
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		g.addVertex(e);
		
		g.addEdge("A","B");
		g.addEdge("A","C");
		g.addEdge("C","B");
		g.addEdge("E","B");
		g.addEdge("D","B");
		
		for(int[] i:g.adjMat){
			System.out.println(Arrays.toString(i));
		}
	}
}
