package com.huawei.classroom.student.h15;

public class ThreadUtil extends Thread {
    private StringBuffer buffer;
    public ThreadUtil(StringBuffer buf) {
        this.buffer = buf;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);//设置在0-1000ms内
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.buffer.append("ok");
        }
    }
}
