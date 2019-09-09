package com.train.ruiq.entity;


/**
 * QQ用户登录记录表 v1.0
 * @author Louise
 * 2019-9-1  17:24
 */

import java.sql.Timestamp;
import java.util.Date;

public class QQOnlineUser extends QQUser {

	private int id;               //记录id
	private int userid;           //登陆的id
	private String ip;            //登录的ip地址
	private Date lastTime;   //登录的时间
	private int state;            //登录状态  0-正在登陆；1-已下线
	
	public QQOnlineUser() {
		super();
	}

	public QQOnlineUser(int id, int userid, String ip, Date lastTime, int state) {
		super();
		this.id = id;
		this.userid = userid;
		this.ip = ip;
		this.lastTime = lastTime;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "QQOnlineUser [id=" + id + ", userid=" + userid + ", ip=" + ip + ", lastTime=" + lastTime + ", state="
				+ state + "]";
	}
	
	
}
