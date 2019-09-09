package com.train.ruiq.view;


import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.*;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class GroupChat extends JPanel{
	private JTextArea receiveMsg;//消息文本接收区
	private JTextArea sendMsg;//消息文本发送区
	private JButton sendButton;//发送消息按钮
	private JButton closeChatWindow;//关闭聊天窗口
	private JButton HistryMsg;//显示聊天记录按钮
	private JScrollPane scrollPane;//用户列表滚轮
	private JScrollPane receiveMsgScroll;//接收消息区滚轮
	private JScrollPane sendMsgScroll;//消息发送区滚轮
	private JList<String> list;  //在线用户列表
	private Box box = Box.createVerticalBox();
	private JLabel onlineUser;//在线用户
	private DefaultListModel<String> listModel;//
	private List<String> userList;
	private JFrame jf;
	public GroupChat() {
		//整块panel
		jf = new JFrame("群聊天选择对象窗口");

		jf.setLocationRelativeTo(null); //居中
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(20,20,20,20));

		JPanel topPl = new JPanel();
		topPl.setLayout(null);
		//topPl.setBorder(BorderFactory.createEtchedBorder());
		//左右两大块panel
		JPanel left  = new JPanel();
		//left.setBorder(BorderFactory.createEtchedBorder());
		JPanel right = new JPanel();
		left.setBounds(0, 0, 600, 569);
		right.setBounds(600, 0, 152, 569);
		right.setBorder(BorderFactory.createEtchedBorder());

		//左边最上面的panel
		JPanel panelUp = new JPanel();
		receiveMsg = new JTextArea(20,50);
		receiveMsg.setEditable(false);
		receiveMsgScroll = new JScrollPane();
		receiveMsgScroll.getViewport().setView(receiveMsg);
		panelUp.add(receiveMsgScroll);
		//左边中间的panel
		JPanel panelCenter= new JPanel();
		panelCenter.add(box);
		HistryMsg = new JButton("聊天记录");
		sendMsg = new JTextArea(6,50);
		sendMsg.setLineWrap(true);
		sendMsgScroll = new JScrollPane();
		sendMsgScroll.getViewport().setView(sendMsg);
		box.add(HistryMsg);
		box.add(sendMsgScroll);

		//左边底部的panel
		JPanel panelBottom = new JPanel(new FlowLayout());
		sendButton = new JButton("发送");
		closeChatWindow = new JButton("退出");
		panelBottom.add(sendButton);
		panelBottom.add(closeChatWindow);
		//右边panel
		onlineUser = new JLabel("在线用户");
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		//测试

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(120,530));
		right.add(onlineUser);
		right.add(scrollPane);
		//添加面板
		left.add(panelUp);
		left.add(panelCenter);
		left.add(panelBottom);
		topPl.add(left);
		topPl.add(right);
		this.add(topPl);

		jf.add(this);
		jf.setSize(800, 640);
		jf.setLocationRelativeTo(null); //居中
		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
		jf.setVisible(false);


	}
	public JTextArea getReceiveMsg() {
		return receiveMsg;
	}
	public JTextArea getSendMsg() {
		return sendMsg;
	}
	public JButton getCloseChatWindow() {
		return closeChatWindow;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JScrollPane getReceiveMsgScroll() {
		return receiveMsgScroll;
	}
	public JScrollPane getSendMsgScroll() {
		return sendMsgScroll;
	}
	public Box getBox() {
		return box;
	}
	public JLabel getOnlineUser() {
		return onlineUser;
	}
	public DefaultListModel<String> getListModel() {
		return listModel;
	}
	public List<String> getUserList() {
		return userList;
	}
	public JFrame getJf() {
		return jf;
	}
	public void setReceiveMsg(JTextArea receiveMsg) {
		this.receiveMsg = receiveMsg;
	}
	public void setSendMsg(JTextArea sendMsg) {
		this.sendMsg = sendMsg;
	}
	public void setSendButton(JButton sendButton) {
		this.sendButton = sendButton;
	}
	public void setCloseChatWindow(JButton closeChatWindow) {
		this.closeChatWindow = closeChatWindow;
	}
	public void setHistryMsg(JButton histryMsg) {
		HistryMsg = histryMsg;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public void setReceiveMsgScroll(JScrollPane receiveMsgScroll) {
		this.receiveMsgScroll = receiveMsgScroll;
	}
	public void setSendMsgScroll(JScrollPane sendMsgScroll) {
		this.sendMsgScroll = sendMsgScroll;
	}
	public void setList(JList<String> list) {
		this.list = list;
	}
	public void setBox(Box box) {
		this.box = box;
	}
	public void setOnlineUser(JLabel onlineUser) {
		this.onlineUser = onlineUser;
	}
	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}
	public void setUserList(List<String> userList) {
		this.userList = userList;
		this.repaint();
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}
	public JList<String> getList() {
		return list;
	}
	public JButton getSendButton() {
		return sendButton;
	}
	public void setReceiveMsg(String receiveMsg) {
		this.receiveMsg.append(receiveMsg+"\n");
	}
	public JButton getHistryMsg() {
		return HistryMsg;
	}


	//获取被选中用户id
	public List<String> getUserId() {
		return list.getSelectedValuesList();
	}
	public void flushjListUsers() {
		ListModel<String> listModel = addListModelItem();
		list = new JList((DefaultListModel) listModel);

		list.setSelectionModel(new DefaultListSelectionModel() {
			@Override
			public void setSelectionInterval(int index0, int index1) {
				if (super.isSelectedIndex(index0)) {
					super.removeSelectionInterval(index0, index1);
				} else {
					super.addSelectionInterval(index0, index1);
				}
			}
		});
		list.setFont(new java.awt.Font("宋体", 0, 18));
		scrollPane.getViewport().setView(list);
		this.repaint();
	}

	public ListModel<String> addListModelItem() {
		ListModel<String> listModel = new DefaultListModel();
		DefaultListModel<String> defaultListModel = (DefaultListModel)listModel;
		for(int i = 0; i < userList.size(); i++) {
			defaultListModel.addElement(userList.get(i));
		}
		return defaultListModel;
	}





}
