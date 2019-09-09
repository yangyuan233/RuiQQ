package com.train.ruiq.dao;

import com.train.ruiq.daoImpl.UserManagerDaoImpl;
import com.train.ruiq.entity.QQHistory;
import com.train.ruiq.entity.QQUser;
import com.train.ruiq.serviceImpl.HistoryService;
import com.train.ruiq.serviceImpl.UserService;

import java.util.Date;

public class testDao {
    public static void main(String[] args) {
//        Date date=new Date();
//        System.out.println(date);
        UserService userService =new UserService();
//        UserManagerDaoImpl um=new UserManagerDaoImpl();
        HistoryService historyService=new HistoryService();
////        System.out.println(um.chazhaozuihou());
//        QQHistory qqHistory=new QQHistory(1000000001,1000000002,"haowen",1);
//        historyService.insertMessage(qqHistory);
//        QQUser qqUser=userService.selectUser(1000000001);

//        System.out.println(flag);
//        HistoryService historyService=new HistoryService();
//        historyService.CheckRecord(1000000001);
        QQUser qqUser=userService.selectUserByName("leo");
        String flag="getInfoBack"+"&&"+Long.toString(qqUser.getId())+"&&"+qqUser.getName()+"&&"+qqUser.getPetName()+"&&"+Integer.toString(qqUser.getSex())+"&&"+qqUser.getMail()+"&&"+Integer.toString(qqUser.getPower());
        System.out.println(flag);
    }
}
