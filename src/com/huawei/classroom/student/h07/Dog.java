package com.huawei.classroom.student.h07;

public class Dog extends GameObject {

	public Dog() {

		// super( Param.DOG_HEALTH,Param.DOG_STRENGTH);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void attack(Soldier soldier) {
		if(soldier.isDestroyed()) return;
		int dx = this.getX() - soldier.getX();
		int dy = this.getY() - soldier.getY();
		double dis = Math.pow(dx * dx + dy * dy, 0.5);
		//System.out.println("dog!!!");
		if (this.getRange() < dis) {
			return;
		}
		if (soldier instanceof RifleSoldier || soldier instanceof RPGSoldier) {
			//System.out.println("dog!!!");
			soldier.setHealth(0);
			Soldier.livingSoldierCount--;
			Soldier.deadedSoldierCount++;
		} else {
			soldier.setHealth(soldier.getHealth() - this.getStrength());
		}
	}

}
