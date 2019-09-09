package com.train.ruiq.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * v0.1
 * @author jdy
 * 2019/9/1
 */
//���촰��
public class ChatWindows extends JPanel{
	private JTextArea receiveMsg;//��Ϣ�ı�������
	private JTextArea sendMsg;//��Ϣ�ı�������
	private JButton sendButton;//������Ϣ��ť
	private JButton closeChatWindow;//�ر����촰��
	private JButton HistryMsg;//��ʾ�����¼��ť
	private JScrollPane receiveMsgScroll;//��Ϣ�ı�����������
	private JScrollPane sendMsgScroll;//��Ϣ����������
	private JLabel targetId;//�������Id
	JFrame jf;
	public ChatWindows(){

		jf = new JFrame("���촰��");
		jf.setResizable(false);

		jf.add(this);
		jf.setSize(600, 800);
//		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);Ĭ��ȫ���رգ�������һ�ֹرշ�ʽ

		jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//�������panel
		JPanel panelUp = new JPanel();
		targetId = new JLabel();
		receiveMsg = new JTextArea(30,52);
		receiveMsg.setEditable(false);
		receiveMsg.setBackground(new Color(255,255,255));
		receiveMsgScroll = new JScrollPane(receiveMsg,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelUp.add(targetId);
		panelUp.add(receiveMsgScroll);
		//�м��panel
		JPanel panelCenter= new JPanel(new FlowLayout(0));
		HistryMsg = new JButton("�����¼");
		sendMsg = new JTextArea(10,52);
		sendMsg.setLineWrap(true);
		sendMsgScroll = new JScrollPane(sendMsg,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelCenter.add(HistryMsg);
		panelCenter.add(sendMsgScroll);
		//�ײ���panel
		JPanel panelBottom = new JPanel(new FlowLayout());
		sendButton = new JButton("����");
		closeChatWindow = new JButton("�˳�");
		panelBottom.add(sendButton);
		panelBottom.add(closeChatWindow);
		this.add(panelUp,BorderLayout.NORTH);
		this.add(panelCenter,BorderLayout.CENTER);
		this.add(panelBottom,BorderLayout.SOUTH);
		jf.setVisible(false);
	}


	public JTextArea getReceiveMsg() {
		return receiveMsg;
	}

	public void setReceiveMsg(JTextArea receiveMsg) {
		this.receiveMsg = receiveMsg;
	}

	public JTextArea getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(JTextArea sendMsg) {
		this.sendMsg = sendMsg;
	}

	public void setSendButton(JButton sendButton) {
		this.sendButton = sendButton;
	}

	public JButton getCloseChatWindow() {
		return closeChatWindow;
	}

	public void setCloseChatWindow(JButton closeChatWindow) {
		this.closeChatWindow = closeChatWindow;
	}

	public JFrame getJf() {
		return jf;
	}

	public void setHistryMsg(JButton histryMsg) {
		HistryMsg = histryMsg;
	}
	public JLabel getTargetId() {
		return targetId;
	}
	public void setTargetId(JLabel targetId) {
		this.targetId = targetId;
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

//	public static void main(String[] args) {
//
//		ChatWindows ch = new ChatWindows();
//	}
}
