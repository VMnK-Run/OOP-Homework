package com.huawei.classroom.student.h06;

public class RifleSoldier extends Roles{
    public RifleSoldier(int x, int y){
        super(x, y, 50, 5, 5);
    }

    @Override
    //重写这个函数，针对狗一击致死
    public void attack(GameObject obj){
    	if(obj.isDestroyed()) return;
        if(obj instanceof Dog){
            obj.beDead();
        }
        else super.attack(obj);
    }
}
