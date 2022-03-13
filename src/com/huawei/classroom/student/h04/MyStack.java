package com.huawei.classroom.student.h04;

public class MyStack {
	private int size; // 最大容量
	private int top = 0; //下一个要插入元素的位置
	private int[] stack;
	public MyStack(int size) {
		this.size = size;
		this.top = 0;
		this.stack = new int[this.size];
	}
	public boolean isEmpty() {
		if(this.top == 0) return true;
		else return false;
	}
	public boolean isFull() {
		if(this.top == this.size) return true;
		else return false;
	}
	public void push(int e) {
		if(this.top < this.size) { 
			this.stack[top] = e;
			this.top++;
		}
	}
	public int pop() {
		int res = this.stack[top - 1];
		this.top--;
		return res;
	}
}