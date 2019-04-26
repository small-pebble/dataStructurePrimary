package com.dyy.hashtable;

public class TestHashTable {

	public static void main(String[] args) {
		StudentInfo s1 = new StudentInfo(16,3);
		StudentInfo s2 = new StudentInfo(17,11);
		StudentInfo s3 = new StudentInfo(18,23);
		StudentInfo s4 = new StudentInfo(19,24);
		StudentInfo s5 = new StudentInfo(20,9);
		
		HashTable ht = new HashTable();
		ht.put(s1);
		ht.put(s2);
		ht.put(s3);
		ht.put(s4);
		ht.put(s5);
		
		System.out.println(ht);
		
		System.out.println(ht.get(18));
	}
}
