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
            case heavyTank -> newTank = new HeavyTank(this.player, this.x, this.y);
            case mediumTank -> newTank = new MediumTank(this.player, this.x, this.y);
            default -> {

            }
        }
        newTank.setType(type.toString());
        BattleField.gameObjects.add(newTank);
        return newTank;
    }
}
