package com.huawei.classroom.student.h17;

public class WarFactory extends Buildings{
    public WarFactory(Player player, int x, int y) {
        super(player, x, y);
        this.health = Params.warFactoryHealth;
        this.range = Params.warFactoryHealth;
        this.strength = Params.warFactoryStrength;
    }

    public Tank building(EnumObjectType type) {
        Tank newTank = null;
        switch (type) {
            case heavyTank :
                newTank = new HeavyTank(this.player, this.x, this.y);
                break;
            case mediumTank :
                newTank = new MediumTank(this.player, this.x, this.y);
                break;
        }
        if(newTank != null) {
            newTank.setType(type.toString());
            BattleField.gamesObjects.add(newTank);
        }
        return newTank;
    }
}
