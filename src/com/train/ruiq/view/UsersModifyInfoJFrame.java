package com.train.ruiq.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
/**
 * 用户修改信息界面类 v1.0
 * @author 82516
 * 2019-09-02
 */
public class UsersModifyInfoJFrame extends JPanel{

	private JLabel jLabelRuiQId = new JLabel("RuiQ ID：", SwingConstants.LEFT);
	private JLabel jLabelPassword = new JLabel("密码：", SwingConstants.LEFT);
	private JLabel jLabelPasswordAgain = new JLabel("确认密码：", SwingConstants.LEFT);
	private JLabel jLabelNickName = new JLabel("昵称：", SwingConstants.LEFT);
	private JLabel jLabelRealName = new JLabel("用户姓名：", SwingConstants.LEFT);
	private JLabel jLabelSex = new JLabel("性别：", SwingConstants.LEFT);
	private JLabel jLabelEMail = new JLabel("邮箱：", SwingConstants.LEFT);

	private JLabel jLabelRuiQIdText = new JLabel("", SwingConstants.LEFT);
	private JPasswordField jPasswordField = new JPasswordField(20);
	private JPasswordField jPasswordAgainField = new JPasswordField(20);
	private JTextField jTextNickNameField = new JTextField(20);
	private JTextField jTextRealNameField = new JTextField(20);
	private JTextField jTextEMailField = new JTextField(40);
	private JComboBox jComboBoxSex = new JComboBox();
	private JButton jButtonSave = new JButton("保存");
	private JButton jButtonExit = new JButton("关闭");

	private JFrame jFrame = null;

	public UsersModifyInfoJFrame() {
		jFrame = new JFrame("修改信息");
		jFrame.setSize(400, 500);
		jFrame.setLocationRelativeTo(null); //居中
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(40, 60, 40, 60));
		//分成两部分
		//上部分
		JPanel jPanelTop = new JPanel(new GridLayout(7, 2, 0, 20));
		jPanelTop.add(jLabelRuiQId); jPanelTop.add(jLabelRuiQIdText);
		jPanelTop.add(jLabelPassword); jPanelTop.add(jPasswordField);
		jPanelTop.add(jLabelPasswordAgain); jPanelTop.add(jPasswordAgainField);
		jPanelTop.add(jLabelNickName); jPanelTop.add(jTextNickNameField);
		jPanelTop.add(jLabelRealName); jPanelTop.add(jTextRealNameField);
		jComboBoxSex.addItem("男");
		jComboBoxSex.addItem("女");
		jPanelTop.add(jLabelSex); jPanelTop.add(jComboBoxSex);
		jPanelTop.add(jLabelEMail);jPanelTop.add(jTextEMailField);
		//下部分
		JPanel jPanelBottom = new JPanel(new FlowLayout(2, 60, 20));
		jPanelBottom.add(jButtonSave);
		jPanelBottom.add(jButtonExit);

		this.add(jPanelTop);
		this.add(jPanelBottom, BorderLayout.SOUTH);
		jFrame.add(this);
		jFrame.setVisible(true);
	}

	public JPasswordField getjPasswordField() {
		return jPasswordField;
	}

	public JPasswordField getjPasswordAgainField() {
		return jPasswordAgainField;
	}

	public JTextField getjTextNickNameField() {
		return jTextNickNameField;
	}

	public JTextField getjTextRealNameField() {
		return jTextRealNameField;
	}

	public JTextField getjTextEMailField() {
		return jTextEMailField;
	}

	public JComboBox getjComboBox() {
		return getjComboBox();
	}

	public JLabel getjLabelRuiQIdText() {
		return jLabelRuiQIdText;
	}

	public JComboBox getjComboBoxSex() {
		return jComboBoxSex;
	}

	public JButton getjButtonSave() {
		return jButtonSave;
	}

	public JButton getjButtonExit() {
		return jButtonExit;
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void initData(String[] array) {
		jLabelRuiQIdText.setText(array[0]);
		jPasswordField.setText(array[1]);
		jPasswordAgainField.setText(array[2]);
		jTextNickNameField.setText(array[3]);
		jTextRealNameField.setText(array[4]);
		//获得ComboBox的项目数
		int num = jComboBoxSex.getItemCount();
		for(int i = 1; i <= num; i++) {
			if(array[5].equals(jComboBoxSex.getItemAt(i))) {
				//选择索引为index的项目
				jComboBoxSex.setSelectedIndex(i);
			}
		}
		jTextEMailField.setText(array[6]);
	}

	public static void main(String[] args) {
		String[] array = {"100001", "123456", "123456", "喵酱", "Lily", "女", "1000025498@qq.com"};
		UsersModifyInfoJFrame usersInfoPanel = new UsersModifyInfoJFrame();
		usersInfoPanel.initData(array);
	}

}
