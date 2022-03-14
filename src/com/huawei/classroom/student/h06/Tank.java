package com.huawei.classroom.student.h06;

//对两种坦克的抽象
public abstract class Tank extends Roles{
    public Tank(int x, int y, int health, int attack, int range){
        super(x, y, health, attack, range);
    }
}
