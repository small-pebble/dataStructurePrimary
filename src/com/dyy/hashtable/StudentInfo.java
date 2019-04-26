package com.dyy.hashtable;

public class StudentInfo {

	private int age;
	private int number;
	
	public StudentInfo(int age,int number){
		this.age = age;
		this.number = number;
	}
	
	public StudentInfo(int age){
		this.age = age;
	}
	
	public StudentInfo(){}
	
	public int hashCode(StudentInfo stuInfo){
		return stuInfo.age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "StudentInfo [age=" + age + ", number=" + number + "]";
	}
	
	
}
