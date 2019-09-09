package com.train.ruiq.view;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * �û��������� v1.0
 * @author 82516
 * 2019-09-01
 */
public class UserMainJFrame extends JPanel{

	//�û��ǳ�
	private JLabel jLabelNickName = new JLabel("", SwingConstants.CENTER);
	//�鿴�����û���ť
	private JButton jButtonOnLineUsers = new JButton("�����û�");
	//�鿴�����û���ť
	private JButton jButtonAllUsers = new JButton("�����û�");
	//ѡ��Ⱥ�İ�ť
	private JButton jButtonGroupChatting = new JButton("����Ⱥ��");
	//�޸ĸ�����Ϣ��ť
	private JButton jButtonModifySelfInfo = new JButton("�޸���Ϣ");
	//�鿴�����û���Ϣ
	private JButton jButtonShowOthersInfo = new JButton("�鿴��Ϣ");
	//��������
	private JButton jButtonStartChatting = new JButton("��������");
	//�û��б�
	private JList jListUsers;
	private List<String> usersList;
	private JScrollPane jScrollPane;
	//�鿴�û���Ϣ�˵�
	private JPopupMenu jPopupMenuUserInfo;
	//�û������˵�
	private JPopupMenu jPopupMenuUserOpration;
	//��ѯ���������б�  - ����/�ǳ�/����
	private JComboBox jComboBoxCondition = new JComboBox();
	//������
	private JTextField jTextFieldSearch = new JTextField(16);
	//��ѯ��ť
	private JButton jButtonSearch = new JButton("��ѯ");

	private JFrame jFrame = null;

	public UserMainJFrame() {
		jFrame = new JFrame("RuiQ");
		jFrame.setSize(360, 600);
		jFrame.setLocation(1500, 0);
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLayout(null);

		//��Ϊ�ĸ�����
		//��һ����
		JPanel jPanelBody1 = new JPanel();
		jPanelBody1.setBounds(10, 0, 360, 120);
		jPanelBody1.setLayout(new FlowLayout(0, 20, 20));  //0 - LEFT
		jPopupMenuUserInfo = new JPopupMenu();
		jPopupMenuUserInfo.add(jButtonModifySelfInfo);
		jLabelNickName.setComponentPopupMenu(jPopupMenuUserInfo);
		jLabelNickName.setFont(new java.awt.Font("����", 1, 28));
		jPanelBody1.add(jLabelNickName);
		jPanelBody1.add(jPopupMenuUserInfo);

		//�ڶ�����
		JPanel jPanelBody2 = new JPanel();
		jPanelBody2.setBounds(10, 120, 360, 80);
		jPanelBody2.setLayout(new FlowLayout(0, 10, 5));
		jComboBoxCondition.addItem("����");
		jComboBoxCondition.addItem("�ǳ�");
		jComboBoxCondition.addItem("����");
		jPanelBody2.add(jComboBoxCondition);
		jPanelBody2.add(jTextFieldSearch);
		jPanelBody2.add(jButtonSearch);
		jPanelBody2.add(jButtonOnLineUsers);
		jPanelBody2.add(jButtonAllUsers);
		//��������
		JPanel jPanelBody3 = new JPanel();
		jPanelBody3.setBounds(0, 200, 360, 300);
		jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(300,280));
		jPopupMenuUserOpration = new JPopupMenu();
		jPopupMenuUserOpration.add(jButtonShowOthersInfo);
		jPopupMenuUserOpration.add(jButtonStartChatting);
		jPanelBody3.add(jScrollPane, BorderLayout.CENTER);
		//���Ĳ���
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
	//ˢ���û�������
	public void flushjListUsers() {
		ListModel<String> listModel = addListModelItem();
		jListUsers = new JList((DefaultListModel) listModel);
		jListUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListUsers.setFont(new java.awt.Font("����", 0, 18));
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
//		String string = "abc&&����&&123&&321444444444&&123&&321&&100003&&45632144444&&8888&&66666&&45645&&589988&&����&&123&&321444444444&&123&&321";
//		String[] strings = string.split("&&");
//
//		UserMainJFrame userMainJFrame = new UserMainJFrame();
//		List<String> list = new ArrayList();
//		for(int i = 0; i < strings.length; i++) {
//			list.add(strings[i]);
//		}

//	}
}
