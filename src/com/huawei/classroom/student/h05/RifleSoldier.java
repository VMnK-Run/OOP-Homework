package com.huawei.classroom.student.h05;

public class RifleSoldier extends Object{
	public RifleSoldier() {
		super(50, 5);
	}
	
	@Override
	public void attack(Object obj) {
		if(obj.isDestroyed()) return;
		if(obj instanceof Dog) {
			obj.getDead();
		}
		else super.attack(obj);
	}
}