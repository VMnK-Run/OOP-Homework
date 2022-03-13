package com.huawei.classroom.student.h06;

public class Barrack extends Buildings{
    public Barrack(int x, int y) {
        super(x, y, 100);
    }

    public Roles traing(EnumObjectType type){
        Roles newRole = null;
        switch (type){
            case dog:
                newRole = new Dog(this.x, this.y);
                break;
            case RPGSoldier:
                newRole = new RPGSoldier(this.x, this.y);
                Soldier.addSoldier();
                break;
            case rifleSoldier:
                newRole = new RifleSoldier(this.x, this.y);
                Soldier.addSoldier();
                break;
            default:
                break;
        }
        return newRole;
    }
}
