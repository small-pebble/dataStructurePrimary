package com.dyy.graph;

public class Vertex {
	private String value;
	public boolean visited;
	
	public Vertex(String value){
		this.value = value;
	}

	public String getValuex() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Vertex [value=" + value + "]";
	} 
	
}
