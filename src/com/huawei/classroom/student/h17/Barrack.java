package com.huawei.classroom.student.h17;

public class Barrack extends Buildings{
    public Barrack(Player player, int x, int y) {
        super(player, x, y);
        this.health = Params.barrackHealth;
        this.range = Params.barrackRange;
        this.strength = Params.barrackStrength;
    }

    public Roles traing(EnumObjectType type) {
        Roles newRole = null;
        switch (type) {
            case dog :
                newRole = new Dog(this.player, this.x, this.y);
                break;
            case RPGSoldier :
                newRole = new RPGSoldier(this.player, this.x, this.y);
                break;
            case rifleSoldier :
                newRole = new RifleSoldier(this.player, this.x, this.y);
                break;
        }
        if(newRole != null) {
            newRole.setType(type.toString());
            BattleField.gamesObjects.add(newRole);
        }
        return newRole;
    }
}
