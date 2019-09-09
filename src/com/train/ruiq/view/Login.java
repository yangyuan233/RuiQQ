package com.train.ruiq.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * v0.1
 * @author jdy
 * 2019/9/1
 */
public class Login extends JPanel {
	//��½��ť
	private JButton login;
	//ע�ᰴť
	private JButton register;
	//�����
	private JPasswordField passjtf;
	//�ı���
	private JTextField nojtf;
	//����
	private JFrame jf = null;
	public JButton getLogin() {
		return login;
	}
	public JPasswordField getPassjtf() {
		return passjtf;
	}
	public JTextField getNojtf() {
		return nojtf;
	}

	public JButton getRegister() {
		return register;
	}

	public JFrame getJf() {
		return jf;
	}
	public Login(){

		jf=new JFrame("��ӭ��½��Q");
		jf.add(this);
		jf.setSize(400,350);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		JPanel jptop=new JPanel();
		jptop.setLayout(new GridLayout(2,2,20,40));
		JLabel actNo=new JLabel("�˺�:",SwingConstants.CENTER);
		JLabel pass=new JLabel("����:",SwingConstants.CENTER);
		nojtf=new JTextField(25);
		passjtf=new JPasswordField(25);
		jptop.add(actNo);jptop.add(nojtf);
		jptop.add(pass);jptop.add(passjtf);
		jptop.setBorder(new EmptyBorder(40,10,40,10));
		JPanel jpbottom=new JPanel();
		login=new JButton("��¼");
		register=new JButton("ע��");
		jpbottom.add(login);jpbottom.add(register);
		this.add(jptop);
		this.add(jpbottom,BorderLayout.SOUTH);
		this.setBorder(new EmptyBorder(40,10,30,10));

	}

}
