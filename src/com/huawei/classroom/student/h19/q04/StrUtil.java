package com.huawei.classroom.student.h19.q04;

import java.util.HashSet;
import java.util.Set;

public class StrUtil {
    public Object removeDulpicatedChar(String str) {
        StringBuilder res = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            if(!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
