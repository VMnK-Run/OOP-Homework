package com.huawei.classroom.student.h06;

public class WarFactory extends Buildings{
    public WarFactory(int x, int y) {
        super(x, y, 100);
    }

    public Tank building(EnumObjectType type) {
        Tank newTank = null;
        switch (type){
            case heavyTank:
                newTank = new HeavyTank(this.x, this.y);
                break;
            case mediumTank:
                newTank = new MediumTank(this.x, this.y);
                break;
            default:
                break;
        }
        return newTank;
    }
}
