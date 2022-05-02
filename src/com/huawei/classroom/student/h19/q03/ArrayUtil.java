package com.huawei.classroom.student.h19.q03;

public class ArrayUtil {
    public int getMin(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }
}
