package com.huawei.classroom.student.h06;

public class GameObject {
    protected int x, y;
    protected int health;

    public GameObject(int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
    }

    //获取生命值
    public int getHealth() {
        return this.health;
    }
    
    //判断是否被摧毁
    public boolean isDestroyed(){
        if(this.health <= 0) return true;
        else return false;
    }
    
    //每个游戏对象都会有的受到伤害函数
    public void getHurt(int attack) {
        if(this.health - attack > 0) this.health -= attack;
        else this.health = 0;
    }

    //直接摧毁该对象
    public void beDead() {
        this.health = 0;
    }

}
