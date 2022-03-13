package com.huawei.classroom.student.h06;

public class GameBase extends Buildings{
    public GameBase(int x, int y) {
        super(x, y, 500);
    }

    public static GameBase createGameBase(int x, int y) {
        GameBase newBase = null;
        newBase = new GameBase(x, y);
        return newBase;
    }

    public Buildings building(EnumObjectType type, int x, int y) {
        Buildings newBuilding = null;
        switch (type) {
            case barrack:
                newBuilding = new Barrack(x, y);
                break;
            case warFactory:
                newBuilding = new WarFactory(x, y);
                break;
            default:
                break;
        }
        return newBuilding;
    }

}
