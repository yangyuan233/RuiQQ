package com.train.ruiq.dao;

import java.util.Vector;

import com.train.ruiq.entity.QQUser;

public interface UserManagerDao {
	public boolean register(QQUser user);//注册
	
	public boolean login(Long id,String password);//登录
	public int chazhaozuihou();
	public QQUser selectUserById(int id);
	
	public QQUser selectUserByName(String name);//通过真实姓名查找用户
	
	public QQUser selectUserByNickname(String nickname);//通过昵称查找用户
	
	public QQUser selectUserByEmail(String email);//通过邮箱模糊查询用户
	
	public void updateUser(QQUser user);//修改用户信息
	
	public boolean deleteUser(int id);//删除用户
	
	public boolean grantUser(int id);//给普通用户授权为管理员
	
	public Vector<QQUser> selectUserAll();//获取所有用户
	
}
