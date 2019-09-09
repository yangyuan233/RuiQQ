package com.train.ruiq.service;

import com.train.ruiq.entity.QQUser;

public interface IUserService {
    public QQUser register(String realname, String petName,String password, int sex,String mail, int power);
    public boolean login(Long id,String password);
    public QQUser selectUser(int id);
    public QQUser selectUserByName(String name);
    public QQUser selectUserByNickname(String name);
    public QQUser selectUserByEmail(String name);
    public QQUser UpdateUser(int id,String name, String password, String petName, String mail, int sex, int power);
}
