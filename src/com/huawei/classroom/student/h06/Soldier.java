package com.huawei.classroom.student.h06;

public class Soldier {
    private static int livingSoldierCount = 0;
    private static int deadSoldierCount = 0;

    public static int getLivingSoldierCount() {
        return livingSoldierCount;
    }

    public static int getDeadSoldierCount() {
        return deadSoldierCount;
    }

    public static void addSoldier() {
        livingSoldierCount++;
    }
    public static void killSoldier() {
        livingSoldierCount--;
        deadSoldierCount++;
    }
}
