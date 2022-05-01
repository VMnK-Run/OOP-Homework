package com.huawei.classroom.student.h17;

public class HeavyTank extends Tank{
    public HeavyTank(Player player, int x, int y) {
        super(player, x, y);
        this.health = Params.heavyTankHealth;
        this.range = Params.heavyTankRange;
        this.strength = Params.heavyTankStrength;
    }
}
