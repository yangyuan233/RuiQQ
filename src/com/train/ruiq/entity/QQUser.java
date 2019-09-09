package com.train.ruiq.entity;

/**
 * QQ用户类 v1.0
 * @author Louise
 * 2019-9-1  17:04
 */

public class QQUser {

	private int id;       //用户id
	private String name;  //用户名
	private String password;//密码
	private String petName;//昵称
	private String mail;    //邮箱
	private int sex;        //性别  0-女；1-男
	private int power;      //权限  0-管理员，1-普通用户
	
	public QQUser() {
		super();
	}
	public QQUser(int id, String name, String password, String petName, String mail, int sex, int power) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.petName = petName;
		this.mail = mail;
		this.sex = sex;
		this.power = power;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	@Override
	public String toString() {
		return "QQUser [id=" + id + ", name=" + name + ", password=" + password + ", petName=" + petName + ", mail="
				+ mail + ", sex=" + sex + ", power=" + power + "]";
	}
	
	
	
}
