package com.train.ruiq.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 * 当前用户信息界面类 v1.0
 * @author 82516
 * 2019-09-01
 */

public class UserSelfInfoJFrame extends JPanel{
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

	public UserSelfInfoJFrame() {
		jFrame = new JFrame("User");
		jFrame.setUndecorated(true);
		jFrame.setSize(320, 200);
		jFrame.setResizable(false);

		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(15, 25, 15, 25));

		JPanel jPanel = new JPanel(new GridLayout(6, 2, 0, 0));
		jPanel.add(jLabelRuiQId); jPanel.add(jLabelRuiQIdText);
		jPanel.add(jLabelNickName); jPanel.add(jLabelNickNameText);
		jPanel.add(jLabelRealName); jPanel.add(jLabelRealNameText);
		jPanel.add(jLabelSex); jPanel.add(jLabelSexText);
		jPanel.add(jLabelEMail); jPanel.add(jLabelEMailText);
		jPanel.add(jLabelUserType); jPanel.add(jLabelUserTypeText);

		this.add(jPanel, BorderLayout.CENTER);
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
}
