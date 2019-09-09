package com.train.ruiq.view;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * 用户主界面类 v1.0
 * @author 82516
 * 2019-09-01
 */
public class UserMainJFrame extends JPanel{

	//用户昵称
	private JLabel jLabelNickName = new JLabel("", SwingConstants.CENTER);
	//查看在线用户按钮
	private JButton jButtonOnLineUsers = new JButton("在线用户");
	//查看所有用户按钮
	private JButton jButtonAllUsers = new JButton("所有用户");
	//选择群聊按钮
	private JButton jButtonGroupChatting = new JButton("在线群聊");
	//修改个人信息按钮
	private JButton jButtonModifySelfInfo = new JButton("修改信息");
	//查看其他用户信息
	private JButton jButtonShowOthersInfo = new JButton("查看信息");
	//发起聊天
	private JButton jButtonStartChatting = new JButton("发起聊天");
	//用户列表
	private JList jListUsers;
	private List<String> usersList;
	private JScrollPane jScrollPane;
	//查看用户信息菜单
	private JPopupMenu jPopupMenuUserInfo;
	//用户操作菜单
	private JPopupMenu jPopupMenuUserOpration;
	//查询条件下拉列表  - 姓名/昵称/邮箱
	private JComboBox jComboBoxCondition = new JComboBox();
	//搜索框
	private JTextField jTextFieldSearch = new JTextField(16);
	//查询按钮
	private JButton jButtonSearch = new JButton("查询");

	private JFrame jFrame = null;

	public UserMainJFrame() {
		jFrame = new JFrame("RuiQ");
		jFrame.setSize(360, 600);
		jFrame.setLocation(1500, 0);
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLayout(null);

		//分为四个部分
		//第一部分
		JPanel jPanelBody1 = new JPanel();
		jPanelBody1.setBounds(10, 0, 360, 120);
		jPanelBody1.setLayout(new FlowLayout(0, 20, 20));  //0 - LEFT
		jPopupMenuUserInfo = new JPopupMenu();
		jPopupMenuUserInfo.add(jButtonModifySelfInfo);
		jLabelNickName.setComponentPopupMenu(jPopupMenuUserInfo);
		jLabelNickName.setFont(new java.awt.Font("宋体", 1, 28));
		jPanelBody1.add(jLabelNickName);
		jPanelBody1.add(jPopupMenuUserInfo);

		//第二部分
		JPanel jPanelBody2 = new JPanel();
		jPanelBody2.setBounds(10, 120, 360, 80);
		jPanelBody2.setLayout(new FlowLayout(0, 10, 5));
		jComboBoxCondition.addItem("姓名");
		jComboBoxCondition.addItem("昵称");
		jComboBoxCondition.addItem("邮箱");
		jPanelBody2.add(jComboBoxCondition);
		jPanelBody2.add(jTextFieldSearch);
		jPanelBody2.add(jButtonSearch);
		jPanelBody2.add(jButtonOnLineUsers);
		jPanelBody2.add(jButtonAllUsers);
		//第三部分
		JPanel jPanelBody3 = new JPanel();
		jPanelBody3.setBounds(0, 200, 360, 300);
		jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(300,280));
		jPopupMenuUserOpration = new JPopupMenu();
		jPopupMenuUserOpration.add(jButtonShowOthersInfo);
		jPopupMenuUserOpration.add(jButtonStartChatting);
		jPanelBody3.add(jScrollPane, BorderLayout.CENTER);
		//第四部分
		JPanel jPanelBody4 = new JPanel();
		jPanelBody4.setBounds(10, 500, 360, 100);
		jPanelBody4.setLayout(new FlowLayout(0, 10, 20));
		jPanelBody4.add(jButtonGroupChatting);

		this.add(jPanelBody1);
		this.add(jPanelBody2);
		this.add(jPanelBody3);
		this.add(jPanelBody4);
		jFrame.add(this);
		jFrame.setVisible(false);
	}

	public JLabel getjLabelNickName() {
		return jLabelNickName;
	}

	public JButton getjButtonOnLineUsers() {
		return jButtonOnLineUsers;
	}

	public JButton getjButtonAllUsers() {
		return jButtonAllUsers;
	}

	public JButton getjButtonGroupChatting() {
		return jButtonGroupChatting;
	}

	public JPopupMenu getjPopupMenuUserInfo() {
		return jPopupMenuUserInfo;
	}

	public JPopupMenu getjPopupMenuUserOpration() {
		return jPopupMenuUserOpration;
	}

	public JButton getjButtonModifySelfInfo() {
		return jButtonModifySelfInfo;
	}

	public JButton getjButtonShowOthersInfo() {
		return jButtonShowOthersInfo;
	}

	public JButton getjButtonStartChatting() {
		return jButtonStartChatting;
	}

	public JList getjListUsers() {
		return jListUsers;
	}

	public JScrollPane getjScrollPane() {
		return jScrollPane;
	}

	public JComboBox getjComboBoxCondition() {
		return jComboBoxCondition;
	}

	public JTextField getjTextFieldSearch() {
		return jTextFieldSearch;
	}

	public JButton getjButtonSearch() {
		return jButtonSearch;
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjListUsers(JList jListUsers) {
		this.jListUsers = jListUsers;
	}

	public List<String> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<String> usersList) {
		this.usersList = usersList;
	}
	//刷新用户主界面
	public void flushjListUsers() {
		ListModel<String> listModel = addListModelItem();
		jListUsers = new JList((DefaultListModel) listModel);
		jListUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListUsers.setFont(new java.awt.Font("宋体", 0, 18));
		jListUsers.setComponentPopupMenu(jPopupMenuUserOpration);
		jListUsers.add(jPopupMenuUserOpration);
		jScrollPane.getViewport().setView(jListUsers);
		this.repaint();
	}

	public ListModel<String> addListModelItem() {
		ListModel<String> listModel = new DefaultListModel();
		DefaultListModel<String> defaultListModel = (DefaultListModel)listModel;
		for(int i = 0; i < usersList.size(); i++) {
			defaultListModel.addElement(usersList.get(i));
		}
		return defaultListModel;
	}

//	public static void main(String[] args) {
//		String string = "abc&&六六&&123&&321444444444&&123&&321&&100003&&45632144444&&8888&&66666&&45645&&589988&&六六&&123&&321444444444&&123&&321";
//		String[] strings = string.split("&&");
//
//		UserMainJFrame userMainJFrame = new UserMainJFrame();
//		List<String> list = new ArrayList();
//		for(int i = 0; i < strings.length; i++) {
//			list.add(strings[i]);
//		}

//	}
}
