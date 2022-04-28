package com.huawei.classroom.student.h16;

public class MyServer {
    public MyServer() {

    }

    public void startListen(int port) {
        ServerThread server = new ServerThread(port);
        server.start();
    }
}
