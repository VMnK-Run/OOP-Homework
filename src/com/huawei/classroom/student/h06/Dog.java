package com.huawei.classroom.student.h06;

public class Dog extends Roles{
    public Dog(int x, int y) {
        super(x, y, 50, 5, 5);
    }

    @Override
    //重写攻击函数，对人有特殊情况
    public void attack(GameObject obj) {
    	if(obj.isDestroyed()) return;
        if(obj instanceof RPGSoldier || obj instanceof RifleSoldier) {
            obj.beDead();
            Soldier.killSoldier();
        }
        else super.attack(obj);
    }
}
