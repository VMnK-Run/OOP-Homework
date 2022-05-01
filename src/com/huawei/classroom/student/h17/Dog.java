package com.huawei.classroom.student.h17;

public class Dog extends Roles{

    public Dog(Player player, int x, int y) {
        super(player, x, y);
        this.health = Params.dogHealth;
        this.range = Params.dogRange;
        this.strength = Params.dogStrength;
    }
}
