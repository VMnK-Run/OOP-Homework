package com.huawei.classroom.student.h08;

public class Dog {
	private int time = 0;
	public Dog() {
		
	}
	public void feed() throws Exception{
		if(this.time >= 3) {
			throw new Exception("I can not eat more!");
		}
		this.time++;
	}
}
