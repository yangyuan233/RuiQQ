package com.train.ruiq.dao;

import java.util.List;


import com.train.ruiq.entity.QQHistory;


public interface HistoryDao {

	public List<QQHistory> selectHistory(long selfid);
	public List<QQHistory> selectHistory(long sendid,long getid);
}
