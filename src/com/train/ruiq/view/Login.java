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
	//µÇÂ½°´Å¥
	private JButton login;
	//×¢²á°´Å¥
	private JButton register;
	//ÃÜÂë¿ò
	private JPasswordField passjtf;
	//ÎÄ±¾¿ò
	private JTextField nojtf;
	//´°Ìå
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

		jf=new JFrame("»¶Ó­µÇÂ½ÈðQ");
		jf.add(this);
		jf.setSize(400,350);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		JPanel jptop=new JPanel();
		jptop.setLayout(new GridLayout(2,2,20,40));
		JLabel actNo=new JLabel("ÕËºÅ:",SwingConstants.CENTER);
		JLabel pass=new JLabel("ÃÜÂë:",SwingConstants.CENTER);
		nojtf=new JTextField(25);
		passjtf=new JPasswordField(25);
		jptop.add(actNo);jptop.add(nojtf);
		jptop.add(pass);jptop.add(passjtf);
		jptop.setBorder(new EmptyBorder(40,10,40,10));
		JPanel jpbottom=new JPanel();
		login=new JButton("µÇÂ¼");
		register=new JButton("×¢²á");
		jpbottom.add(login);jpbottom.add(register);
		this.add(jptop);
		this.add(jpbottom,BorderLayout.SOUTH);
		this.setBorder(new EmptyBorder(40,10,30,10));

	}

}
