package com.train.ruiq.service;

import com.train.ruiq.entity.QQUser;

import java.util.Vector;

public interface IAdminService {
    public boolean deleteUserById(int id);
    public QQUser GrantUserById(int id);
    public Vector<QQUser> SelectUserAll();
}
