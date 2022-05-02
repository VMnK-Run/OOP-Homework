package com.huawei.classroom.student.h19.q05;

public class Person {
    public String name;
    public int chinese;
    public int math;
    public int total;
    Person(String name, int chinese, int math) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.total = math + chinese;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public void setTotal() {
        this.total = this.math + this.chinese;
    }
}
