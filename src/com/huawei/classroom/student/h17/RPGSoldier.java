package com.huawei.classroom.student.h17;

public class RPGSoldier extends Soldiers{
    public RPGSoldier(Player player, int x, int y) {
        super(player, x, y);
        this.health = Params.RPGSoldierHealth;
        this.range = Params.RPGSoldierRange;
        this.strength = Params.RPGSoldierStrength;
    }
}
