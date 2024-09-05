package com.ruby.java.ch07.inheritance;

public class Student extends Person {
	private String major;
	public Student(String name, int age, String major) {
		super(name,age);
		this.major=major;
		
		System.out.println("Student 생성자 실행");
		// TODO Auto-generated constructor stub
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	public String toString() {
//		return this.getName() + ":"+ this.getAge()+major;
		return super.toString()+major;
	}
	public Student() {
		System.out.println("Student 생성자 실행");
	}
}
