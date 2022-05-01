package com.huawei.classroom.student.h17;

public class MediumTank extends Tank{

    public MediumTank(Player player, int x, int y) {
        super(player, x, y);
        this.health = Params.mediumTankHealth;
        this.range = Params.mediumTankRange;
        this.strength = Params.mediumTankStrength;
    }
}
