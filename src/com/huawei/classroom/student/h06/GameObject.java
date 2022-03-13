package com.huawei.classroom.student.h06;

public class GameObject {
    protected int x, y;
    protected int health;

    public GameObject(int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isDestroyed(){
        if(this.health <= 0) return true;
        else return false;
    }

    public void getHurt(int attack) {
        if(this.health - attack > 0) this.health -= attack;
        else this.health = 0;
    }

    public void beDead() {
        this.health = 0;
    }

}
