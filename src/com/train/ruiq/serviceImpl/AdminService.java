package com.train.ruiq.serviceImpl;

import com.train.ruiq.daoImpl.UserManagerDaoImpl;
import com.train.ruiq.entity.QQUser;
import com.train.ruiq.service.IAdminService;

import java.util.Vector;

public class AdminService implements IAdminService {
    UserManagerDaoImpl um=null;
    @Override
    public boolean deleteUserById(int id) {
        um =new UserManagerDaoImpl();
        um.deleteUser(id);
        return false;
    }

    @Override
    public QQUser GrantUserById(int id) {
        um =new UserManagerDaoImpl();
        um.grantUser(id);
        return null;
    }

    @Override
    public Vector<QQUser> SelectUserAll() {
        um =new UserManagerDaoImpl();
        Vector<QQUser> list =um.selectUserAll();
        return list;
    }
}
