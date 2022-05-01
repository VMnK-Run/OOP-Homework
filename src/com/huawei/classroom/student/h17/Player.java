package com.huawei.classroom.student.h17;

public class Player {
    private String name;

    public Player() {
        this.name = null;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
