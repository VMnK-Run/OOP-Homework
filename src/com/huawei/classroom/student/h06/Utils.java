package com.huawei.classroom.student.h06;

public class Utils {
    public static double getDistance(GameObject obj1, GameObject obj2) {
        return Math.sqrt((obj1.x - obj2.x) *(obj1.x - obj2.x) + (obj1.y - obj2.y) * (obj1.y - obj2.y));
    }
}
