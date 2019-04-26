package com.dyy.hashtable;

import java.util.Arrays;

public class HashTable {
	StudentInfo[] hashTable = new StudentInfo[100];
	
	public void put(StudentInfo s){
		hashTable[s.getAge()] = s;
	}
	
	public StudentInfo get(int age){
		return hashTable[age];
	}

	@Override
	public String toString() {
		return "HashTable [hashTable=" + Arrays.toString(hashTable) + "]";
	}
	
}
