package com.train.ruiq.view;

import java.awt.BorderLayout;
import java.awt.Panel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HistoryMsgPanel extends JPanel{
	//��ʷ�����¼�ı���
	private JTextArea chatHistory;
	JFrame jf;
	//����
	private JScrollPane chatHistoryScroll;

	public JTextArea getChatHistory() {
		return chatHistory;
	}

	public void setChatHistory(JTextArea chatHistory) {
		this.chatHistory = chatHistory;
	}

	public JFrame getJf() {
		return jf;
	}

	public HistoryMsgPanel() {
		jf = new JFrame("��ʷ��¼����");
		jf.setResizable(false);
		jf.add(this);
		jf.setSize(600, 800);
		jf.setLocationRelativeTo(null);;
		jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);


		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(20,20,20,20));
		Panel topPl = new Panel();
		chatHistory = new JTextArea(43,48);
		chatHistory.setEditable(false);
		chatHistory.setLineWrap(true);//�����Զ�����
		chatHistoryScroll = new JScrollPane(chatHistory,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		chatHistoryScroll.setViewportView(chatHistory);
		topPl.add(chatHistoryScroll);
		this.add(topPl);
		jf.setVisible(false);
	}

//	public static void main(String[] args) {
////		try {
////			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
////			}catch(Exception e) {
////				System.out.println(e);
////			}
//		HistoryMsgPanel ch = new HistoryMsgPanel();
//
//	}
}
