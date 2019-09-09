package com.train.ruiq.server;


import com.train.ruiq.entity.QQHistory;
import com.train.ruiq.entity.QQUser;
import com.train.ruiq.serviceImpl.HistoryService;
import com.train.ruiq.serviceImpl.MessageService;
import com.train.ruiq.serviceImpl.UserService;

import java.io.IOException;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Iterator;

public class ServerThred extends Thread {
    Socket clientSocket;
    MessageService messageService=new MessageService();
    UserService userService =new UserService();
    HistoryService historyService=new HistoryService();
//    static Hashtable<QQUser,Socket> table =new  Hashtable<QQUser,Socket> ();
    static Hashtable<Long,Socket> idTable =new  Hashtable<Long, Socket> ();
    public ServerThred(Socket s){
        clientSocket=s;
    }

    @Override
    public void run() {
        try{
            while(true)
            {
                String clientMessage=messageService.getMessage(clientSocket);
                String msh=AnalysisMessage(clientMessage,clientSocket);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public String AnalysisMessage(String message,Socket s) throws IOException  {
        String flag="";
        String[] msgs=message.split("&&");
        if(msgs[0].equals("login")) {
            boolean bool = userService.login(Long.valueOf(msgs[1]),msgs[2]);
            if(bool)
            {
                QQUser qqUser = userService.selectUser(Integer.parseInt(msgs[1]));
                flag=msgs[0]+"Back&&true&&"+Integer.toString(qqUser.getId())+"&&"+Integer.toString(qqUser.getPower());
                idTable.put(Long.valueOf(msgs[1]),s);
                String str="otherUserLogin";
                for(Iterator itr = idTable.keySet().iterator(); itr.hasNext();){
                    Long key = (long) itr.next();
                    str=str+"&&"+key;
                }
                for(Iterator itr = idTable.keySet().iterator(); itr.hasNext();){
                    Long key = (long) itr.next();
                    Socket socket = (Socket) idTable.get(key);
                    messageService.sendMesageToCurrentSocket(socket,str);
                }

            }
            else
            {
                flag=msgs[0]+"Back&&false";
            }
            messageService.sendMesageToCurrentSocket(s,flag);

        }
        else if(msgs[0].equals("regist")) {
            QQUser user = userService.register( msgs[1], msgs[2],msgs[3], Integer.parseInt(msgs[4]), msgs[5],Integer.parseInt(msgs[6]));
            if(user!=null)
            {
                flag =msgs[0]+"Back&&True";
            }
            else
            {
                flag =msgs[0]+"Back&&False&&id“—¥Ê‘⁄";
            }
            messageService.sendMesageToCurrentSocket(s,flag);
        }
        else if(msgs[0].equals("sentPrivateMessage")) {
            Socket socket=(Socket)idTable.get(Long.valueOf(msgs[2]));
//            QQUser qqUser = userService.selectUser(msgs[1]);
            QQHistory his = new  QQHistory(Long.valueOf(msgs[1]),Long.valueOf(msgs[2]),msgs[3],1);
            historyService.insertMessage(his);
            flag="receivePrivatemessage"+"&&"+msgs[2]+"&&"+msgs[1]+"&&"+msgs[3];
            messageService.sendMesageToCurrentSocket(socket,flag);
        }
        else if(msgs[0].equals("sentPublicMessage")) {
            QQHistory qqHistory;
            for (int i = 3; i <msgs.length ; i++) {
                qqHistory= new  QQHistory(Long.valueOf(msgs[1]),Long.valueOf(msgs[i]),msgs[2],0);
                historyService.insertMessage(qqHistory);
                Socket socket=(Socket)idTable.get(Long.valueOf(msgs[i]));
                flag="receivePublicmessage"+"&&"+msgs[i]+"&&"+msgs[1]+"&&"+msgs[2];
                messageService.sendMesageToCurrentSocket(socket,flag);
            }
        }
        else if(msgs[0].equals("getInfo")) {
            QQUser qqUser=null;
            if(msgs[1].equals("id"))
            {
                qqUser=userService.selectUser(Integer.parseInt(msgs[2]));
            }
            else if(msgs[1].equals("–’√˚")){
                qqUser=userService.selectUserByName(msgs[2]);
            }
            else if(msgs[1].equals("Í«≥∆")){
                qqUser=userService.selectUserByNickname(msgs[2]);
            }
            else if(msgs[1].equals("” œ‰")){
                qqUser=userService.selectUserByEmail(msgs[2]);
            }
            if(qqUser==null){
                flag="getInfoBack"+"&&"+"false";
                messageService.sendMesageToCurrentSocket(s,flag);
            }
            else {
                flag="getInfoBack"+"&&"+Long.toString(qqUser.getId())+"&&"+qqUser.getName()+"&&"+qqUser.getPetName()+"&&"+Integer.toString(qqUser.getSex())+"&&"+qqUser.getMail()+"&&"+Integer.toString(qqUser.getPower());
                messageService.sendMesageToCurrentSocket(s,flag);
            }

        }
        else if(msgs[0].equals("getPrivateHistorymessage")) {
            String historyMessage=historyService.CheckRecord(Long.parseLong(msgs[2]),Long.parseLong(msgs[1]));
            System.out.println(historyMessage);
            flag="getPrivateHistorymessageBack&&"+msgs[2]+"&&"+historyMessage;
            messageService.sendMesageToCurrentSocket(s,flag);
        }
        else if(msgs[0].equals("getPublicHistorymessage")) {
            String historyMessage=historyService.CheckRecord(Long.parseLong(msgs[1]));
            flag="getPrivateHistorymessageBack&&"+msgs[1]+historyMessage;
            messageService.sendMesageToCurrentSocket(s,flag);
        }

        return flag;
    }
}
