package com.train.ruiq.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Register extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel userName;
	private JLabel password;
	private JLabel secondPassword;
	private JLabel petName;
	private JLabel mail;
	private JLabel sex ;
	private JLabel Manager;
	private JTextField userIdTextFiled;
	private JPasswordField secondPasswordField;
	private JTextField nameTextFiled;
	private JPasswordField passwordFiled;
	private JTextField petNameTextFiled;
	private JTextField mailTextFiled;
	private JButton regist;
	private JButton back;
	private JLabel title;
	private JComboBox<String> sexBox;
	private JComboBox<String> managerBox;
	private JFrame jf;


	public JLabel getSex() {
		return sex;
	}

	public JTextField getUserIdTextFiled() {
		return userIdTextFiled;
	}

	public JPasswordField getSecondPasswordField() {
		return secondPasswordField;
	}

	public JTextField getNameTextFiled() {
		return nameTextFiled;
	}

	public JPasswordField getPasswordFiled() {
		return passwordFiled;
	}

	public JTextField getPetNameTextFiled() {
		return petNameTextFiled;
	}

	public JTextField getMailTextFiled() {
		return mailTextFiled;
	}

	public JButton getRegist() {
		return regist;
	}

	public JButton getBack() {
		return back;
	}

	public void setSecondPasswordField(JPasswordField secondPasswordField) {
		this.secondPasswordField = secondPasswordField;
	}

	public void setNameTextFiled(JTextField nameTextFiled) {
		this.nameTextFiled = nameTextFiled;
	}

	public void setPasswordFiled(JPasswordField passwordFiled) {
		this.passwordFiled = passwordFiled;
	}

	public void setPetNameTextFiled(JTextField petNameTextFiled) {
		this.petNameTextFiled = petNameTextFiled;
	}

	public void setMailTextFiled(JTextField mailTextFiled) {
		this.mailTextFiled = mailTextFiled;
	}

	public JComboBox<String> getSexBox() {
		return sexBox;
	}

	public JComboBox<String> getManagerBox() {
		return managerBox;
	}

	public JFrame getJf() {
		return jf;
	}

	public Register() {

		jf = new JFrame("ע��");
		jf.add(this);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setSize(400,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(30,0,20,50));
		Panel topPl = new Panel(new BorderLayout());
		Panel centerPl = new Panel(new GridLayout(7,2,10,20));
		Panel bottomPl = new Panel(new FlowLayout(2,60,5));
		title = new JLabel("��ӭʹ�� RuiQ",SwingConstants.CENTER);
		title.setFont(new Font("����",1,20));
		userName = new JLabel("������",SwingConstants.CENTER);
		nameTextFiled = new JTextField(20);
		password = new JLabel("����",SwingConstants.CENTER);
		passwordFiled = new JPasswordField(20);
		secondPassword = new JLabel("ȷ������",SwingConstants.CENTER);
		secondPasswordField = new JPasswordField(20);
		sex = new JLabel("�Ա�",SwingConstants.CENTER);
		sexBox = new JComboBox<String>();
		sexBox.addItem("��");
		sexBox.addItem("Ů");
		Manager = new JLabel("�û�����",SwingConstants.CENTER);
		managerBox = new JComboBox<String>();
		managerBox.addItem("����Ա");
		managerBox.addItem("��ͨ�û�");
		managerBox.setEnabled(true);
		mail = new JLabel("����",SwingConstants.CENTER);
		mailTextFiled = new JTextField(40);
		petName = new JLabel("�ǳ�",SwingConstants.CENTER);
		petNameTextFiled = new JTextField(20);
		regist = new JButton("�ύ");
		back = new JButton("����");

		topPl.add(title,BorderLayout.NORTH);
		centerPl.add(Manager);centerPl.add(managerBox);
		centerPl.add(sex);centerPl.add(sexBox);
		centerPl.add(userName);centerPl.add(nameTextFiled);
		centerPl.add(password);centerPl.add(passwordFiled);
		centerPl.add(secondPassword);centerPl.add(secondPasswordField);
		centerPl.add(mail);centerPl.add(mailTextFiled);
		centerPl.add(petName);centerPl.add(petNameTextFiled);
		bottomPl.add(regist);
		bottomPl.add(back);

		this.add(topPl,BorderLayout.NORTH);
		this.add(centerPl,BorderLayout.CENTER);
		this.add(bottomPl,BorderLayout.SOUTH);
		jf.setVisible(false);
	}
	public static void main(String[] args) {
		Register register = new Register();
	}
}
