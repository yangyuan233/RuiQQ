package com.train.ruiq.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 * 管理员主界面类 v1.0
 * @author 82516
 * 2019-09-01
 */
public class AdminMainJFrame extends JPanel{
	//用户昵称
	private JLabel jLabelNickName = new JLabel("", SwingConstants.CENTER);
	//查看在线用户按钮
	private JButton jButtonOnLineUsers = new JButton("在线用户");
	//查看所有用户按钮
	private JButton jButtonAllUsers = new JButton("所有用户");
	//选择群聊按钮
	private JButton jButtonGroupChatting = new JButton("在线群聊");
	//增加用户按钮
	private JButton jButtonAddUser = new JButton("增加用户");
	//修改个人信息按钮
	private JButton jButtonModifySelfInfo = new JButton("修改信息");

	//修改他人信息按钮
	private JButton jButtonModifyOthersInfo = new JButton("修改信息");
	//查看其他用户信息按钮
	private JButton jButtonShowOthersInfo = new JButton("查看信息");
	//发起聊天按钮
	private JButton jButtonStartChatting = new JButton("发起聊天");
	//查看聊天记录按钮
	private JButton jButtonShowChattingRecord = new JButton("查看记录");
	//授权用户
	private JButton jButtonGrantUser = new JButton("授权用户");
	//删除用户
	private JButton jButtonDelUser = new JButton("删除用户");
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

	private	JFrame jFrame = null;

	public AdminMainJFrame() {

		jFrame = new JFrame("RuiQ");

		jFrame.setSize(360, 600);
		jFrame.setLocation(1500, 0);
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
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
		jScrollPane.setPreferredSize(new Dimension(320,290));
		jPopupMenuUserOpration = new JPopupMenu();
		jPopupMenuUserOpration.add(jButtonShowOthersInfo);
		jPopupMenuUserOpration.add(jButtonStartChatting);
		jPopupMenuUserOpration.add(jButtonModifyOthersInfo);
		jPopupMenuUserOpration.add(jButtonShowChattingRecord);
		jPopupMenuUserOpration.add(jButtonGrantUser);
		jPopupMenuUserOpration.add(jButtonDelUser);
		jPanelBody3.add(jScrollPane, BorderLayout.CENTER);

		//第四部分
		JPanel jPanelBody4 = new JPanel();
		jPanelBody4.setBounds(10, 500, 360, 100);
		jPanelBody4.setLayout(new FlowLayout(0, 10, 20));
		jPanelBody4.add(jButtonGroupChatting);
		jPanelBody4.add(jButtonAddUser);

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

	public JButton getjButtonAddUser() {
		return jButtonAddUser;
	}

	public JButton getjButtonShowChattingRecord() {
		return jButtonShowChattingRecord;
	}

	public JButton getjButtonGrantUser() {
		return jButtonGrantUser;
	}

	public JButton getjButtonDelUser() {
		return jButtonDelUser;
	}

	public JScrollPane getjScrollPane() {
		return jScrollPane;
	}

	public JTextField getjTextFieldSearch() {
		return jTextFieldSearch;
	}

	public JButton getjButtonSearch() {
		return jButtonSearch;
	}

	public JButton getjButtonModifyOthersInfo() {
		return jButtonModifyOthersInfo;
	}

	public JList getjListUsers() {
		return jListUsers;
	}

	public JComboBox getjComboBoxCondition() {
		return jComboBoxCondition;
	}

	public JFrame getjFrame() {
		return jFrame;
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
	}

	public ListModel<String> addListModelItem() {
		ListModel<String> listModel = new DefaultListModel();
		DefaultListModel<String> defaultListModel = (DefaultListModel)listModel;
		for(int i = 1; i < usersList.size(); i++) {
			defaultListModel.addElement(usersList.get(i));
		}
		return defaultListModel;
	}

	public static void main(String[] args) {
		String string = "abc&&六六&&123&&321444444444&&123&&321&&100003&&45632144444&&8888&&66666&&45645&&589988&&六六&&123&&321444444444&&123&&321";
		String[] strings = string.split("&&");

		AdminMainJFrame adminMainJFrame = new AdminMainJFrame();
		List<String> list = new ArrayList();
		for(int i = 0; i < strings.length; i++) {
			list.add(strings[i]);
		}
		adminMainJFrame.setUsersList(list);
		adminMainJFrame.flushjListUsers();
	}
}
