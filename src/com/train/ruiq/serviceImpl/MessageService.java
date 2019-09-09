package com.train.ruiq.serviceImpl;

import com.train.ruiq.service.IMessageService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class MessageService implements IMessageService {
    @Override
    public Vector<String> sendMesage(Vector<Socket> list, Socket s, String str) throws IOException {
        Iterator<Socket> it = list.iterator();
        char index ='A';
        while (it.hasNext())
        {

            Socket member = it.next();

            PrintStream memberReceive = new PrintStream(member.getOutputStream());
            String[] msgs=str.split("%%");
            memberReceive.println(msgs[0]+"%%"+msgs[1]);
            index ++;
        }
        return null;
    }

    @Override
    public String getMessage(Socket s) throws IOException {
        String ss;
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        ss=br.readLine();
        return ss;
    }
    public void sendMesageToCurrentSocket(Socket s,String message) throws IOException
    {
        PrintStream myReceive = new PrintStream(s.getOutputStream());
        myReceive.println(message);
    }
}
