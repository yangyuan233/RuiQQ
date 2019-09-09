package com.train.ruiq.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class QQserver {
    static Vector<Socket> list=new Vector<Socket>();;

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket=new ServerSocket(8888);
            while (true){
                Socket clientSocket=serverSocket.accept();
                list.add(clientSocket);
                new ServerThred(clientSocket).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
