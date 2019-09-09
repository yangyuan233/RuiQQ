package com.train.ruiq.service;

import com.train.ruiq.entity.QQMessage;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

public interface IMessageService {
    public Vector<String> sendMesage(Vector<Socket> list, Socket s, String str)throws IOException;//要把当前Socket传来的消息发给集合中的所有socket
    public String getMessage(Socket s)throws IOException;//接受当前Socket的消息，把发送人，时间，消息等信息作为字符串保存

}
