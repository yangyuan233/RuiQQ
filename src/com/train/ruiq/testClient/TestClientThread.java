package com.train.ruiq.testClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TestClientThread extends Thread{
    TestClient testClient ;
    Socket s;
    public TestClientThread(TestClient testClient)
    {
        this.testClient=testClient;
        try {
            s = new Socket("127.0.0.1",8888);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        testClient.jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stubc
                try {
                    new PrintStream(s.getOutputStream()).println(testClient.jfd.getText());
                    testClient.jfd.setText("");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        });
    }
    public void run()
    {
        try {
            InputStream is = s.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br =new BufferedReader(isr);

            while(true)
            {
                testClient.jt1.append(br.readLine()+'\n');
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
