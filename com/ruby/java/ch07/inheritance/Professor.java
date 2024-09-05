package com.ruby.java.ch07.inheritance;

public class Professor extends Person {
	private String subject;
	public Professor(String name, int age, String subject) {
		super(name,age);
		this.subject=subject;
		
	
		// TODO Auto-generated constructor stub
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String toString() {
//		return this.getName() + ":"+ this.getAge()+subject;
		return super.toString()+subject;
	}
	public Professor() {
		System.out.println("Professor 생성자 실행");
	}
}
