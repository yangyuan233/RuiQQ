package com.train.ruiq.daoImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

import javax.swing.text.AbstractDocument.LeafElement;

import com.train.ruiq.dao.UserManagerDao;
import com.train.ruiq.entity.QQOnlineUser;
import com.train.ruiq.entity.QQUser;
import com.train.ruiq.util.JdbcUtil;


public class UserManagerDaoImpl implements UserManagerDao {

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public int chazhaozuihou() {
		int needid =0;
		con = JdbcUtil.getConnection();//建立连接
		String sql = "select * from T_user order by id DESC limit 1;";
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.first();
			needid=rs.getInt(1);


		} catch (SQLException e){
			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, null);
		}
		return needid;
	}

	@Override
	public boolean register(QQUser user) {
		con = JdbcUtil.getConnection();//建立连接
		String sql = "INSERT INTO T_User(name,password,petname,mail,sex,power)VALUES(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getPetName());
			pstmt.setString(4, user.getMail());
			pstmt.setInt(5, user.getSex());
			pstmt.setInt(6, user.getPower());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			try {
				con.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			JdbcUtil.release(con, pstmt, null);
		}
		return true;
	}

	@Override
	public boolean login(Long id, String password) {
		con = JdbcUtil.getConnection();
		String sql = "select * from T_User where id = ? and password = ?";
		QQOnlineUser oluser = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();//执行查询，返回查询pstmt的 ResultSet对象。
			while(rs.next()) {
				oluser = new QQOnlineUser();
				oluser.setState(1);
				Date lasttime= new Date();
				oluser.setLastTime(lasttime);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, rs);
		}
		return false;
	}

	@Override
	public QQUser selectUserByName(String name) {
		con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM T_User where name = ?";
		QQUser user = null;
		try {
			pstmt = con.prepareStatement(sql);//将SQL语句发送到数据库
			pstmt.setString(1, name);//将指定的参数设置为给定的Java String值
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user = new QQUser();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPetName(rs.getString(4));
				user.setMail(rs.getString(5));
				user.setSex(rs.getInt(6));
				user.setPower(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, rs);
		}
		return user;
	}

	@Override
	public QQUser selectUserByNickname(String nickname) {
		con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM T_User where petname = ?";
		QQUser user = null;
		try {
			pstmt = con.prepareStatement(sql);//将SQL语句发送到数据库
			pstmt.setString(1, nickname);//将指定的参数设置为给定的Java String值
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user = new QQUser();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPetName(rs.getString(4));
				user.setMail(rs.getString(5));
				user.setSex(rs.getInt(6));
				user.setPower(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, rs);
		}
		return user;
	}

	@Override
	public QQUser selectUserById(int id) {
		con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM T_User where id = ?";
		QQUser user = null;
		try {
			pstmt = con.prepareStatement(sql);//将SQL语句发送到数据库
			pstmt.setInt(1, id);//将指定的参数设置为给定的Java String值
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user = new QQUser();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPetName(rs.getString(4));
				user.setMail(rs.getString(5));
				user.setSex(rs.getInt(6));
				user.setPower(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, rs);
		}
		return user;
	}

	@Override
	public QQUser selectUserByEmail(String email) {
		con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM T_User where mail = ?";
		QQUser user = null;
		try {
			pstmt = con.prepareStatement(sql);//将SQL语句发送到数据库
			pstmt.setString(1, email);//将指定的参数设置为给定的Java String值
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user = new QQUser();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPetName(rs.getString(4));
				user.setMail(rs.getString(5));
				user.setSex(rs.getInt(6));
				user.setPower(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.release(con, pstmt, rs);
		}
		return user;
	}

	@Override
	public void updateUser(QQUser user) {
		con = JdbcUtil.getConnection();//建立连接
		String sql = "update T_User set name=?,password=?,peyname=?,mail=?,sex=?,power=? where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getPetName());
			pstmt.setString(4, user.getMail());
			pstmt.setInt(5, user.getSex());
			pstmt.setInt(6, user.getPower());
			pstmt.setInt(7, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			JdbcUtil.release(con, pstmt, null);
		}
	}

	@Override
	public boolean deleteUser(int id) {
		con=JdbcUtil.getConnection();
		String sql = "delete from T_User where id=?";
		QQUser user = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
				return false;
		}finally {
			JdbcUtil.release(con, pstmt, null);
		}
		return true;
	}

/**
 * 用户管理Dao层 （授权、查找所有用户）V1.0
 * @author Louise
 * 2019-9-1 18:05
 */
	@Override
	public boolean grantUser(int id) {
		// TODO Auto-generated method stub
		con = JdbcUtil.getConnection();//建立连接
		String sql = "update T_User set power=? where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			return false;
		}finally {
			JdbcUtil.release(con, pstmt, null);
		}
		return true;
	}

	@Override
	public Vector<QQUser> selectUserAll() {
		// TODO Auto-generated method stub
		con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM T_User";
		Vector<QQUser> users = new Vector<>();
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			JdbcUtil.printResultSet(rs);
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

}
