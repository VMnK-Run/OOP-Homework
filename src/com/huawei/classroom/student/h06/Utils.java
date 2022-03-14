package com.huawei.classroom.student.h06;

//将获取距离的函数进行封装
public class Utils {
    public static double getDistance(GameObject obj1, GameObject obj2) {
        return Math.sqrt((obj1.x - obj2.x) *(obj1.x - obj2.x) + (obj1.y - obj2.y) * (obj1.y - obj2.y));
    }
}
