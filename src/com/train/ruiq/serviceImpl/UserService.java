package com.train.ruiq.serviceImpl;

import com.train.ruiq.daoImpl.UserManagerDaoImpl;
import com.train.ruiq.entity.QQUser;
import com.train.ruiq.service.IUserService;

public class UserService implements IUserService {
    QQUser user =null;
    UserManagerDaoImpl um=null;
    @Override
    public QQUser register(String realname, String petName,String password, int sex,String mail, int power) {
        um =new UserManagerDaoImpl();
        int id=um.chazhaozuihou()+1;
        user =new QQUser(id, realname, password, petName, mail, sex, power);
        if((um.selectUserById(id))==null)
        {
            um.register(user);
            return user;
        }
        else{
            return null;//注册失败，id已存在
        }
    }

    @Override
    public boolean login(Long id, String password) {
        um=new UserManagerDaoImpl();
        return um.login(id,password);
    }

    @Override
    public QQUser selectUser(int id) {
        um=new UserManagerDaoImpl();
       return um.selectUserById(id);
    }

    @Override
    public QQUser UpdateUser(int id, String name, String password, String petName, String mail, int sex, int power) {
        user =new QQUser(id, name, password, petName, mail, sex, power);
        um.updateUser(user);
        return user;
    }


    @Override
    public QQUser selectUserByName(String name) {
        um=new UserManagerDaoImpl();
        return um.selectUserByName(name);
    }

    @Override
    public QQUser selectUserByNickname(String nickname) {
        um=new UserManagerDaoImpl();
        return um.selectUserByNickname(nickname);
    }

    @Override
    public QQUser selectUserByEmail(String email) {
        um=new UserManagerDaoImpl();
        return um.selectUserByEmail(email);
    }
}
