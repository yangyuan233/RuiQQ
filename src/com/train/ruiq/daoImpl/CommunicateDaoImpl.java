package com.train.ruiq.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 * 消息业务Dao层 V1.0
 * @author Louise
 * 2019-9-1 18:15
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import com.train.ruiq.dao.CommunicateDao;
import com.train.ruiq.entity.QQHistory;
import com.train.ruiq.entity.QQUser;
import com.train.ruiq.util.DateToTimestamp;
import com.train.ruiq.util.JdbcUtil;

public class CommunicateDaoImpl implements CommunicateDao {

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public Vector<QQUser> DisplayOnlineUser() {

		con = JdbcUtil.getConnection();
		String sql = "SELECT T_User.* FROM T_User INNER JOIN T_OnLineUser ON T_User.id=T_OnLineUser.User_id WHERE state=1";
		Vector<QQUser> users = new Vector<>();
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				QQUser user = new QQUser();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPetName(rs.getString(4));
				user.setMail(rs.getString(5));
				user.setSex(rs.getInt(6));
				user.setPower(rs.getInt(7));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, rs);
		}
		return users;
	}

	@Override
	public void insertMessage_mes(QQHistory his) {
		con = JdbcUtil.getConnection();//建立连接

		String sql = "INSERT INTO t_message(get_id,send_id,message,time) VALUES(?,?,?,?)";
		try {
			Date now_date1 = new Date();
			java.sql.Timestamp date1=DateToTimestamp.dateToTime(now_date1);
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, his.getSendid());
			pstmt.setLong(2, his.getGetid());
			pstmt.setString(3, his.getMessage());
			pstmt.setTimestamp(4, date1);


		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, null);

		}
	}
	@Override
	public void insertMessage_his(QQHistory his) {
		con = JdbcUtil.getConnection();//建立连接
		String sql = "INSERT INTO t_history(fromid,toid,msg,DateTime,type) VALUES(?,?,?,?,?)";
		try {

			Date now_date2 = new Date();
			java.sql.Timestamp date2=DateToTimestamp.dateToTime(now_date2);
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, his.getSendid());
			pstmt.setLong(2, his.getGetid());
			pstmt.setString(3, his.getMessage());
			pstmt.setTimestamp(4, date2);
			pstmt.setInt(5, his.getType());
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, null);
		}
	}

}
