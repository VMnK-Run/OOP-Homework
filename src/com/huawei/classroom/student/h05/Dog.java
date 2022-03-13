package com.huawei.classroom.student.h05;

public class Dog extends Object {
	public Dog() {
		super(50, 5);
	}
	
	@Override
	public void attack(Object obj) {
		if(obj.isDestroyed()) return;
		if(obj instanceof RPGSoldier || obj instanceof RifleSoldier) {
			obj.getDead();
			Soldier.destroySoldier();
		}
		else super.attack(obj);
	}
}