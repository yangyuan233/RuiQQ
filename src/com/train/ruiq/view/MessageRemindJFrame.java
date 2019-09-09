package com.train.ruiq.view;

import javax.swing.*;
import java.awt.*;

/**
 * 消息提醒类
 * @author 82516
 * 2019-09-02
 */
public class MessageRemindJFrame extends JPanel{
	JLabel jLabelMessage = new JLabel("", SwingConstants.CENTER);

	public JLabel getjLabelMessage() {
		return jLabelMessage;
	}

	public MessageRemindJFrame() {
		JFrame jFrame = new JFrame("消息提示");

		jFrame.setSize(320, 200);
		jFrame.setLocation(1600, 850);
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//this.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel jPanel = new JPanel();
		jPanel.setBounds(10, 50, 300, 100);
		jLabelMessage.setFont(new java.awt.Font("宋体", 1, 12));
		jPanel.add(jLabelMessage);
		this.add(jPanel);
		jFrame.add(this);
		jFrame.setVisible(false);
	}
	public void remind(String[] array) {
//		jLabelMessage.setText("您有一条来自用户"+array[1]+"的消息");
		jLabelMessage.setText("用户15648655555555555555\n向您发来了一条消息");
	}
	public static void main(String[] args) {
		String[] array = {"100001", "喵酱", "Lily","女","1000025498@qq.com"};
		MessageRemindJFrame messageRemindJFrame = new MessageRemindJFrame();
		messageRemindJFrame.remind(array);
	}

}
