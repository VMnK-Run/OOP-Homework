package com.huawei.classroom.student.h05;
public class Soldier {
	private static int livingCount = 0;
	private static int deadedCount = 0;
	public static int getLivingSoldierCount() {
		// TODO 自动生成的方法存根
		return livingCount;
	}

	public static int getDeadedSoldierCount() {
		// TODO 自动生成的方法存根
		return deadedCount;
	}
	public static void addSoldier() {
		livingCount++;
	}
	public static void destroySoldier() {
		livingCount--;
		deadedCount++;
	}
}