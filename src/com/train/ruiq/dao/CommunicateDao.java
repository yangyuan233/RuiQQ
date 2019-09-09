package com.train.ruiq.dao;

import java.util.List;
import java.util.Vector;

import com.train.ruiq.entity.QQHistory;
import com.train.ruiq.entity.QQUser;

public interface CommunicateDao {

	public List<QQUser> DisplayOnlineUser();
	public void insertMessage_his(QQHistory his);
	public void insertMessage_mes(QQHistory his);


}
