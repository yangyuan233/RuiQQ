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
//聊天窗口
public class ChatWindows extends JPanel{
	private JTextArea receiveMsg;//消息文本接收区
	private JTextArea sendMsg;//消息文本发送区
	private JButton sendButton;//发送消息按钮
	private JButton closeChatWindow;//关闭聊天窗口
	private JButton HistryMsg;//显示聊天记录按钮
	private JScrollPane receiveMsgScroll;//消息文本接收区滚轮
	private JScrollPane sendMsgScroll;//消息发送区滚轮
	private JLabel targetId;//聊天对象Id
	JFrame jf;
	public ChatWindows(){

		jf = new JFrame("聊天窗口");
		jf.setResizable(false);

		jf.add(this);
		jf.setSize(600, 800);
//		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);默认全部关闭，改用另一种关闭方式

		jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//最上面的panel
		JPanel panelUp = new JPanel();
		targetId = new JLabel();
		receiveMsg = new JTextArea(30,52);
		receiveMsg.setEditable(false);
		receiveMsg.setBackground(new Color(255,255,255));
		receiveMsgScroll = new JScrollPane(receiveMsg,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelUp.add(targetId);
		panelUp.add(receiveMsgScroll);
		//中间的panel
		JPanel panelCenter= new JPanel(new FlowLayout(0));
		HistryMsg = new JButton("聊天记录");
		sendMsg = new JTextArea(10,52);
		sendMsg.setLineWrap(true);
		sendMsgScroll = new JScrollPane(sendMsg,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelCenter.add(HistryMsg);
		panelCenter.add(sendMsgScroll);
		//底部的panel
		JPanel panelBottom = new JPanel(new FlowLayout());
		sendButton = new JButton("发送");
		closeChatWindow = new JButton("退出");
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
