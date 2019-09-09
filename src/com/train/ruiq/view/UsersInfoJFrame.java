package com.train.ruiq.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 * 查看其他用户信息界面类
 * @author 82516
 * 2019-09-02
 */
public class UsersInfoJFrame extends JPanel{

	private JLabel jLabelRuiQId = new JLabel("RuiQ ID：", SwingConstants.LEFT);
	private JLabel jLabelNickName = new JLabel("昵称：", SwingConstants.LEFT);
	private JLabel jLabelRealName = new JLabel("用户姓名：", SwingConstants.LEFT);
	private JLabel jLabelSex = new JLabel("性别：", SwingConstants.LEFT);
	private JLabel jLabelEMail = new JLabel("邮箱：", SwingConstants.LEFT);
	private JLabel jLabelUserType = new JLabel("用户类型", SwingConstants.LEFT);

	private JLabel jLabelRuiQIdText = new JLabel("", SwingConstants.LEFT);
	private JLabel jLabelNickNameText = new JLabel("", SwingConstants.LEFT);
	private JLabel jLabelRealNameText = new JLabel("", SwingConstants.LEFT);
	private JLabel jLabelSexText = new JLabel("", SwingConstants.LEFT);
	private JLabel jLabelEMailText = new JLabel("", SwingConstants.LEFT);
	private JLabel jLabelUserTypeText = new JLabel("", SwingConstants.LEFT);

	private JFrame jFrame = null;

	public UsersInfoJFrame() {
		jFrame = new JFrame("用户信息");
		jFrame.setSize(400, 500);
		jFrame.setLocationRelativeTo(null); //居中
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(60, 60, 0, 60));
		JPanel jPanel = new JPanel(new GridLayout(8, 2, 0, 30));
		jPanel.add(jLabelRuiQId); jPanel.add(jLabelRuiQIdText);
		jPanel.add(jLabelNickName); jPanel.add(jLabelNickNameText);
		jPanel.add(jLabelRealName); jPanel.add(jLabelRealNameText);
		jPanel.add(jLabelSex); jPanel.add(jLabelSexText);
		jPanel.add(jLabelEMail); jPanel.add(jLabelEMailText);
		jPanel.add(jLabelUserType); jPanel.add(jLabelUserTypeText);
		this.add(jPanel);
		jFrame.add(this);
		jFrame.setVisible(false);
	}

	public JLabel getjLabelRuiQIdText() {
		return jLabelRuiQIdText;
	}

	public JLabel getjLabelNickNameText() {
		return jLabelNickNameText;
	}

	public JLabel getjLabelRealNameText() {
		return jLabelRealNameText;
	}

	public JLabel getjLabelSexText() {
		return jLabelSexText;
	}

	public JLabel getjLabelEMailText() {
		return jLabelEMailText;
	}

	public JLabel getjLabelUserTypeText() {
		return jLabelUserTypeText;
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjLabelRuiQIdText(JLabel jLabelRuiQIdText) {
		this.jLabelRuiQIdText = jLabelRuiQIdText;
	}

	public void setjLabelNickNameText(JLabel jLabelNickNameText) {
		this.jLabelNickNameText = jLabelNickNameText;
	}

	public void setjLabelRealNameText(JLabel jLabelRealNameText) {
		this.jLabelRealNameText = jLabelRealNameText;
	}

	public void setjLabelSexText(JLabel jLabelSexText) {
		this.jLabelSexText = jLabelSexText;
	}

	public void setjLabelEMailText(JLabel jLabelEMailText) {
		this.jLabelEMailText = jLabelEMailText;
	}

	public void setjLabelUserTypeText(JLabel jLabelUserTypeText) {
		this.jLabelUserTypeText = jLabelUserTypeText;
	}
}
