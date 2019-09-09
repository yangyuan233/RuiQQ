package com.train.ruiq.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.train.ruiq.dao.HistoryDao;
import com.train.ruiq.entity.QQHistory;
import com.train.ruiq.entity.QQUser;
import com.train.ruiq.util.JdbcUtil;

public class HistoryDaoImpl implements HistoryDao {

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public List<QQHistory> selectHistory(long selfid) {//查找所有聊天记录
		con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM T_History where (fromid=? or toid=?) and type=0";
		List<QQHistory> historys = new ArrayList();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,selfid);
			pstmt.setLong(2,selfid);
			ResultSet rs = pstmt.executeQuery();
//			JdbcUtil.printResultSet(rs);
			while(rs.next()) {
				QQHistory history = new QQHistory();
				history.setId(rs.getInt(1));
				history.setSendid(rs.getInt(2));
				history.setGetid(rs.getInt(3));
				history.setMessage(rs.getString(4));
				history.setSendTime(rs.getDate(5));
				historys.add(history);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, rs);
		}
		return historys;
	}

	@Override
	public List<QQHistory> selectHistory(long sendid, long getid) {//查找某两个人的聊天记录
		con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM T_History where ((fromid=? and toid=?) or (fromid=? and toid=?)) and type = 1";
		//消息有来回，所以应该查找双方的
		List<QQHistory> historys = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, sendid);
			pstmt.setLong(2, getid);
			pstmt.setLong(3, getid);
			pstmt.setLong(4, sendid);
			ResultSet rs = pstmt.executeQuery();
//			JdbcUtil.printResultSet(rs);
			while(rs.next()) {
				QQHistory history = new QQHistory();
				history.setId(rs.getInt(1));
				history.setSendid(rs.getInt(2));
				history.setGetid(rs.getInt(3));
				history.setMessage(rs.getString(4));
				history.setSendTime(rs.getTimestamp(5));
				historys.add(history);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, rs);
		}
		return historys;
	}


}
