package com.huawei.classroom.student.h05;

public class Barrack extends Object {
	public Barrack() {
		super(100);
	}
	public Object traing(EnumObjectType type) {
		Object newObject = null;
		switch(type) {
			case dog: 
				newObject = new Dog();
				break;
			case rifleSoldier:
				newObject = new RifleSoldier();
				break;
			case RPGSoldier:
				newObject = new RPGSoldier();
				break;
			default:
				break;
		}
		if(type != EnumObjectType.dog) Soldier.addSoldier();
		return newObject;
	}
}