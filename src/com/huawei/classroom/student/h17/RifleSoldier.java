package com.huawei.classroom.student.h17;

public class RifleSoldier extends Soldiers{
    public RifleSoldier(Player player, int x, int y) {
        super(player, x, y);
        this.health = Params.rifleSoldierHealth;
        this.range = Params.rifleSoldierRange;
        this.strength = Params.rifleSoldierStrength;
    }
}
