package com.huawei.classroom.student.h06;


//可以移动的游戏角色
public abstract class Roles extends GameObject implements Move{
    protected int attack;
    protected double range;
    public Roles(int x, int y, int health, int attack, int range) {
        super(x, y, health);
        this.attack = attack;
        this.range = range;
    }
    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    //每个角色可以攻击
    public void attack(GameObject obj) {
        if(obj.isDestroyed()) return;
        if(Utils.getDistance(this, obj) <= this.range){
            obj.getHurt(this.attack);
        }
        if(obj.isDestroyed()){
            if(obj instanceof RPGSoldier || obj instanceof RifleSoldier) Soldier.killSoldier();
        }
    }
}
