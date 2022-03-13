package com.huawei.classroom.student.h06;

public class RifleSoldier extends Roles{
    public RifleSoldier(int x, int y){
        super(x, y, 50, 5, 5);
    }

    @Override
    public void attack(GameObject obj){
    	if(obj.isDestroyed()) return;
        if(obj instanceof Dog){
            obj.beDead();
        }
        else super.attack(obj);
    }
}
