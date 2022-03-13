package com.huawei.classroom.student.h05;

public class Object {
	private int health;
	private int attack;
	public Object(int health, int attack) {
		this.health = health;
		this.attack = attack;
	}
	public Object(int health) {
		this.health = health;
	}
	public int getHealth() {
		return this.health;
	}
	public void getHurt(int attack) {
		if(this.health - attack > 0) this.health = this.health - attack;
		else this.health = 0;
	}
	public void getDead() {
		this.health = 0;
	}
	public boolean isDestroyed() {
		if(this.health <= 0) return true;
		else return false;
	}
	public void attack(Object obj) {
		if(obj.isDestroyed()) return;
		obj.getHurt(this.attack);
		if(obj.isDestroyed() && (obj instanceof RPGSoldier || obj instanceof RifleSoldier)) Soldier.destroySoldier();
	}
}
