package com.huawei.classroom.student.h04;

public class Apple {
	private String color = "red";
	private int size = 10;
	
	public Apple() {
//		this.color = "red";
//		this.size = 10;
	}
	public Apple(int size, String color) {
		this.size = size;
		this.color = color;
	}
	public String getColor() {
		return this.color;
	}
	public int getSize() {
		return this.size;
	}
}
