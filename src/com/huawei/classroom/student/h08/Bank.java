package com.huawei.classroom.student.h08;

public class Bank {
	private int remain;
	public Bank() {
		this.remain = 0;
	}
    public void save(int i) {
    	this.remain += i;
    }
    public void get(int i) throws NoMoneyException{
    	if(this.remain >= i) {
    		this.remain -= i;
    	}
    	else {
    		throw new NoMoneyException();
    	}
    }
}
