package com.train.ruiq.entity;

import java.util.Date;

/**
 * QQ历史消息类 v1.0
 * @author Louise
 * 2019-9-1  17:15
 */

public class QQHistory extends QQMessage {

	private int id;                //记录id
	private long sendid;            //发送用户
	private long getid;             //接收用户
	private String message;        //聊天记录
	private Date sendTime;    //发送时间
	private int type;  //0 公聊，1 私聊

	public QQHistory() {
		super();
	}

	public QQHistory(long sendid, long getid, String message, int type) {
		super();
		this.id = id;
		this.sendid = sendid;
		this.getid = getid;
		this.message = message;
//		this.sendTime = sendTime;
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getSendid() {
		return sendid;
	}
	public void setSendid(long sendid) {
		this.sendid = sendid;
	}
	public long getGetid() {
		return getid;
	}
	public void setGetid(long getid) {
		this.getid = getid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "QQHistory [id=" + id + ", sendid=" + sendid + ", getid=" + getid + ", message=" + message
				+ ", sendTime=" + sendTime + ", type=" + type + "]";
	}


}
