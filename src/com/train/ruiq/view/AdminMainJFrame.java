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
 * ����Ա�������� v1.0
 * @author 82516
 * 2019-09-01
 */
public class AdminMainJFrame extends JPanel{
	//�û��ǳ�
	private JLabel jLabelNickName = new JLabel("", SwingConstants.CENTER);
	//�鿴�����û���ť
	private JButton jButtonOnLineUsers = new JButton("�����û�");
	//�鿴�����û���ť
	private JButton jButtonAllUsers = new JButton("�����û�");
	//ѡ��Ⱥ�İ�ť
	private JButton jButtonGroupChatting = new JButton("����Ⱥ��");
	//�����û���ť
	private JButton jButtonAddUser = new JButton("�����û�");
	//�޸ĸ�����Ϣ��ť
	private JButton jButtonModifySelfInfo = new JButton("�޸���Ϣ");

	//�޸�������Ϣ��ť
	private JButton jButtonModifyOthersInfo = new JButton("�޸���Ϣ");
	//�鿴�����û���Ϣ��ť
	private JButton jButtonShowOthersInfo = new JButton("�鿴��Ϣ");
	//�������찴ť
	private JButton jButtonStartChatting = new JButton("��������");
	//�鿴�����¼��ť
	private JButton jButtonShowChattingRecord = new JButton("�鿴��¼");
	//��Ȩ�û�
	private JButton jButtonGrantUser = new JButton("��Ȩ�û�");
	//ɾ���û�
	private JButton jButtonDelUser = new JButton("ɾ���û�");
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

	private	JFrame jFrame = null;

	public AdminMainJFrame() {

		jFrame = new JFrame("RuiQ");

		jFrame.setSize(360, 600);
		jFrame.setLocation(1500, 0);
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
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
		jScrollPane.setPreferredSize(new Dimension(320,290));
		jPopupMenuUserOpration = new JPopupMenu();
		jPopupMenuUserOpration.add(jButtonShowOthersInfo);
		jPopupMenuUserOpration.add(jButtonStartChatting);
		jPopupMenuUserOpration.add(jButtonModifyOthersInfo);
		jPopupMenuUserOpration.add(jButtonShowChattingRecord);
		jPopupMenuUserOpration.add(jButtonGrantUser);
		jPopupMenuUserOpration.add(jButtonDelUser);
		jPanelBody3.add(jScrollPane, BorderLayout.CENTER);

		//���Ĳ���
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

	//ˢ���û�������
	public void flushjListUsers() {
		ListModel<String> listModel = addListModelItem();
		jListUsers = new JList((DefaultListModel) listModel);
		jListUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListUsers.setFont(new java.awt.Font("����", 0, 18));
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
		String string = "abc&&����&&123&&321444444444&&123&&321&&100003&&45632144444&&8888&&66666&&45645&&589988&&����&&123&&321444444444&&123&&321";
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
