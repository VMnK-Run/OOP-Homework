package com.huawei.classroom.student.h16;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
    private final int MAX_LEN = 4096;
    private final String EXIT = "bye" + "\r\n";
    private final int port;
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    ServerThread(int port) {
        this.port = port;
        this.serverSocket = null;
        this.socket = null;
        this.in = null;
        this.out = null;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(this.port);//创建服务端
            socket = serverSocket.accept();//等待客户端连接
            in = socket.getInputStream();
            out = socket.getOutputStream();
            byte[] data = new byte[MAX_LEN];
            int readed = in.read(data);
            String line = new String(data, 0, readed);
            while (!EXIT.equals(line)) {
                out.write(line.getBytes());
                readed = in.read(data);
                line = new String(data, 0, readed);
            }
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             close(in);
             close(out);
             close(socket);
             close(serverSocket);
        }

    }

    public void close(Closeable inout) {
        if(inout != null) {
            try {
                inout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
