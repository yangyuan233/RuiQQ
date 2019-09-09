package com.train.ruiq.entity;
/**
 * QQ消息类 v1.0
 * @author Louise
 * 2019-9-1  17:11
 */
import java.sql.Timestamp;
import java.util.Date;

public class QQMessage {

	private int id;             //短信id
	private long sendid;         //短信发送者
	private long getid;          //短信接收者
	private String message;     //短信内容
	private Date sendTime;      //发送时间


	public QQMessage() {
		super();
	}

	public QQMessage(long sendid, long getid, String message) {
		super();
		this.id = id;
		this.sendid = sendid;
		this.getid = getid;
//		this.message = message;
		this.sendTime = sendTime;
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

	@Override
	public String toString() {
		return "QQMessage [id=" + id + ", sendid=" + sendid + ", getid=" + getid + ", message=" + message
				+ ", sendTime=" + sendTime + "]";
	}

}

