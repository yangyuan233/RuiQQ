package com.train.ruiq.testClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TestClient {
    static JTextArea jt1;
    static JButton jb ;
    static JTextField jfd;
    static Socket s;
    public TestClient ()
    {
        JFrame jf =new JFrame () ;
        jf.setTitle("QQ聊天");
        jf.setSize(600, 400);
        jf.setResizable(true);
        jf.setVisible(true);
        jf.setLayout(null);
        jt1 =new JTextArea();
        jt1.setBorder(new TitledBorder("聊天记录"));
        JScrollPane jp= new JScrollPane(jt1);
        jf.add(jp);
        jf.add(jt1);
        jt1.setSize(400,200);
        jt1.setLocation(100,20);
        jfd = new JTextField();
        jfd.setBorder(new TitledBorder("输入框"));
        jf.add(jfd);
        jfd.setSize(400,50);
        jfd.setLocation(100,240);
        jb = new JButton();
        jf.add(jb);
        jb.setText("发送");
        jb.setSize(80,50);
        jb.setLocation(10, 240);

    }
    public  static void main(String[] args)
    {
        TestClient testClient = new TestClient();
        TestClientThread testClientThread =new TestClientThread(testClient);
        testClientThread.start();
    }
}

