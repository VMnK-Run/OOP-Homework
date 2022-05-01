package com.huawei.classroom.student.h17;

public class GameBase extends Buildings{

    public GameBase(Player player, int x, int y) {
        super(player, x, y);
        this.health = Params.baseHealth;
        this.range = Params.baseRange;
        this.strength = Params.baseStrength;
    }

    public Buildings building(EnumObjectType type, int x, int y) {
        Buildings newBuilding = null;
        switch (type) {
            case barrack -> newBuilding = new Barrack(this.player, x, y);
            case warFactory -> newBuilding = new WarFactory(this.player, x, y);
            default -> {
            }
        }
        newBuilding.setType(type.toString());
        BattleField.gameObjects.add(newBuilding);
        return newBuilding;
    }
}
