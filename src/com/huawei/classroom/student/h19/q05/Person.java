package com.huawei.classroom.student.h19.q05;

public class Person implements Comparable<Object> {
    public String name;
    public int chinese;
    public int math;
    public int english;
    public int other;
    public int total;
    Person(String name) {
        this.name = name;
        this.chinese = 0;
        this.math = 0;
        this.english = 0;
        this.other = 0;
        this.total = 0;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public void setEnglish(int english) {this.english = english;}

    public void setOther(int other) {this.other += other;}

    public void setTotal() {
        this.total = this.math + this.chinese + this.english + this.other;
    }

    @Override
    public int compareTo(Object o) {
        Person that = (Person) o;
        if(this.total > that.total) {
            return 1;
        } else if(this.total == that.total) {
            if(this.chinese > that.chinese) {
                return 1;
            } else if(this.chinese == that.chinese) {
                if(this.math > that.math) {
                    return 1;
                } else if(this.math == that.math){
                    if(this.english > that.english) {
                        return 1;
                    }
                    else return -1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }

    }
}
