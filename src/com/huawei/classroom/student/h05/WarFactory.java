package com.huawei.classroom.student.h05;

public class WarFactory extends Object {
	public WarFactory() {
		super(100);
	}
	public Tank building(EnumObjectType type) {
		Tank newTank = null;
		switch(type) {
		case heavyTank:
			newTank = new HeavyTank();
			break;
		case mediumTank:
			newTank = new MediumTank();
			break;
		default: break;
		}
		return newTank;
	}
}