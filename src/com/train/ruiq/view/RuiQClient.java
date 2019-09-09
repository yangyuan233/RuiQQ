package com.train.ruiq.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class RuiQClient implements Runnable {
	
	private static List<String> nowclients;//当前的在线人员
	private static Socket client=null;//接口
	private String clientid;//自己的id
	
	UserMainJFrame userMainJFrame = new UserMainJFrame();
	AdminMainJFrame adminMainJFrame = new AdminMainJFrame();
	UserSelfInfoJFrame userSelfInfoJFrame = new UserSelfInfoJFrame();
	UsersInfoJFrame usersInfoJFrame = new UsersInfoJFrame();
//	UsersModifyInfoJFrame usersModifyInfoJFrame = new UsersModifyInfoJFrame();
	MessageRemindJFrame messageRemindJFrame = new MessageRemindJFrame();
	Login login = new Login();
	Register register = new Register();
	ChatWindows cw =new ChatWindows();
	HistoryMsgPanel hm = new HistoryMsgPanel();
	GroupChat gc= new GroupChat();//群聊界面
	
	private String clientLogin;
		
	public String getClientLogin() {
		return clientLogin;
	}

	public void setClientLogin(String clientLogin) {
		this.clientLogin = clientLogin;
	}

	public RuiQClient() throws UnknownHostException, IOException {
		login.getJf().setVisible(true);
		addListener();
		client=new Socket("127.0.0.1",8888);
		nowclients=new LinkedList();
		userMainJFrame.setUsersList(nowclients);
		userMainJFrame.flushjListUsers();
	}
	
	
	public void addListener() {
		//登录事件监听
		login.getLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id= login.getNojtf().getText();
			    String password = new String(login.getPassjtf().getPassword());
			    String dataProtocol = "login"+"&&"+id+"&&"+password;
			    setClientLogin(dataProtocol);
			    try {
					SendMessage(dataProtocol);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		//点击注册按钮事件
		login.getRegister().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login.getJf().dispose();
				System.out.println("111");
				register.getJf().setVisible(true);
				
			}
		});
		//在注册界面点击返回按钮事件
		register.getBack().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				register.getJf().dispose();
				login.getJf().setVisible(true);
				register.getNameTextFiled().setText("");
				register.getPetNameTextFiled().setText("");
				register.getPasswordFiled().setText("");
				register.getSecondPasswordField().setText("");
				register.getMailTextFiled().setText("");
				
			}
		});
		//注册界面提交按钮事件
		register.getRegist().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(register.getNameTextFiled().getText().equals(""))
				{
					JOptionPane.showMessageDialog(register.getJf(), "用户名不能为空");
				}
				else if(register.getPasswordFiled().getText().equals(""))
				{
					JOptionPane.showMessageDialog(register.getJf(), "密码不能为空");
				}
				else if(register.getPasswordFiled().getText().length()<6)
				{
					JOptionPane.showMessageDialog(register.getJf(), "密码应该大于等于6位");
				}
				else if(!register.getPasswordFiled().getText().equals(register.getSecondPasswordField().getText()))
				{
					JOptionPane.showMessageDialog(register.getJf(), "两次密码不同请重新输入");
				}
				else if(!(register.getMailTextFiled().getText().matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")))
				{
					JOptionPane.showMessageDialog(register.getJf(), "输入的邮箱不合法");
				}
				else {
					clientLogin= "regist&&"+register.getNameTextFiled().getText()+"&&"+register.getPetNameTextFiled().getText()+"&&"+
							new String( register.getPasswordFiled().getPassword())+"&&"
							+changeSexToNumber(register.getSexBox().getSelectedItem().toString())+"&&"+register.getMailTextFiled().getText()+"&&"+changeTypeToNumber(register.getManagerBox().getSelectedItem().toString());}
				try {
					SendMessage(clientLogin);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});


		adminMainJFrame.getjButtonStartChatting().addActionListener(new ActionListener() {//管理员主界面点击私聊，生成私聊界面
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cw.getJf().setVisible(true); //私聊窗口
			}
		});
		userMainJFrame.getjButtonStartChatting().addActionListener(new ActionListener() {//普通用户主界面点击私聊，生成私聊界面
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String join = String.join(",", userMainJFrame.getjListUsers().getSelectedValuesList());//得到选中id
//				System.out.println(userMainJFrame.getjListUsers().getSelectedValuesList());
				cw.getTargetId().setText(join);
				cw.getJf().setVisible(true);
			}
		});
		userMainJFrame.getjButtonShowOthersInfo().addActionListener(new ActionListener() {//查看选中用户信息信息
			@Override
			public void actionPerformed(ActionEvent e) {
				String join = String.join(",", userMainJFrame.getjListUsers().getSelectedValuesList());
				String msg="getInfo&&id&&"+join;
				System.out.println(msg);
				try {
					SendMessage(msg);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		adminMainJFrame.getjButtonGroupChatting().addActionListener(new ActionListener() {//管理员主界面点击群聊，生成群聊界面
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gc.getJf().setVisible(true); //群聊
			}
		});
		userMainJFrame.getjButtonGroupChatting().addActionListener(new ActionListener() {//普通用户主界面点击群聊，生成群聊界面
			@Override
			public void actionPerformed(ActionEvent arg0) {

				gc.setUserList(nowclients);
				gc.addListModelItem();
				gc.flushjListUsers();
				gc.getJf().setVisible(true);

			}
		});
		cw.getSendButton().addActionListener(new ActionListener() {//私聊界面发送私聊消息
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String armid=cw.getTargetId().getText();//私聊界面对象.获得私聊对象的id
				
				String msg="sentPrivateMessage&&"+clientid+"&&"+armid+"&&"+cw.getSendMsg().getText();
				System.out.println(msg);
				cw.setReceiveMsg("我:"+getNowTime()+":"+cw.getSendMsg().getText());
				try {
					SendMessage(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		gc.getHistryMsg().addActionListener(new ActionListener() {//群聊界面点击聊天记录，生成聊天记录窗口
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hm.setVisible(true);


			}
		});


		gc.getSendButton().addActionListener(new ActionListener() {//群聊界面发送群聊消息
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String msg="sentPublicMessage&&"+clientid+"&&"+gc.getSendMsg().getText()+"";
				gc.setReceiveMsg("我:"+getNowTime()+": "+gc.getSendMsg().getText());

				List<String> list = gc.getUserId();
				if(list.size()==0){
					for(int i=0;i<nowclients.size();i++)//for循环遍历群聊右侧选择的对象id,加到msg中
					{
						msg=msg+"&&"+nowclients.get(i);//待修改
					}
				}else {
				//获得群聊的对象的id
				for(int i=0;i<list.size();i++)//for循环遍历群聊右侧选择的对象id,加到msg中
				{
					msg=msg+"&&"+list.get(i);//待修改
				}
				}
				try {
					System.out.println(msg);
					SendMessage(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					gc.getSendMsg().setText("");
				}
			}
		});
		userMainJFrame.getjButtonSearch().addActionListener(new ActionListener() {//查询按钮，根据id搜索信息
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=userMainJFrame.getjComboBoxCondition().getSelectedItem().toString();
				System.out.println(str);
				String msg="getInfo&&"+str+"&&"+userMainJFrame.getjTextFieldSearch().getText();
				System.out.println(msg);
				try {
					SendMessage(msg);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		cw.getHistryMsg().addActionListener(new ActionListener() {//私聊界面点击聊天记录，生成聊天记录窗口
			@Override
			public void actionPerformed(ActionEvent e) {
				hm.setVisible(true);
				String armid=cw.getTargetId().getText();//私聊界面对象.获得私聊对象的id
				String msg="getPrivateHistorymessage&&"+armid+"&&"+clientid;

				try {
					SendMessage(msg);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
//		userMainJFrame.getjButtonModifySelfInfo().addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				usersModifyInfoJFrame.setVisible(true);
//			}
//		});
	
	}
	//拆分数据协议
	public String[] splitStringToArray(String str) {
		String[] strArray = str.split("&&");
		return strArray;
	}
	

	@Override
	public void run() {
		InputStream is;
		try {
			is = client.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br =new BufferedReader(isr);
			while(true)
			{
	        String str =br.readLine();
	        AcceptiInfo(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void SendMessage(String msg) throws IOException {//发送消息,待完成

		new PrintStream(client.getOutputStream()).println(msg);
	}
	public void AcceptiInfo(String str)//获取消息
	{
		System.out.println(str);
		String[] msgs =str.split("&&");
		String flag =msgs[0];
		if(flag.equals("otherUserLogin"))//其他用户上线，
		{
			nowclients.clear();
			for(int i=1;i<msgs.length;i++) {
				nowclients.add(msgs[i]);
			}
			userMainJFrame.setUsersList(nowclients);
			userMainJFrame.flushjListUsers();

			//修改主界面和群聊的人员列表
		}
		if(flag.equals("loginBack"))//登录
		{
			if(msgs[1].equals("true"))
			{		
				clientid=msgs[2];
				String type=msgs[3];
				if(type.equals("0")) {
					//普通用户界面显示
					userMainJFrame.setUsersList(nowclients);
					userMainJFrame.flushjListUsers();
					userMainJFrame.getjFrame().setVisible(true);
					userMainJFrame.getjLabelNickName().setText(msgs[2]);
					login.getJf().dispose();
				}
				else {
					//new管理员界面
					adminMainJFrame.setUsersList(nowclients);
					adminMainJFrame.flushjListUsers();
					adminMainJFrame.getjFrame().setVisible(true);
					adminMainJFrame.getjLabelNickName().setText(msgs[2]);
					login.getJf().dispose();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(login.getJf(), "登录失败");
			}
		}
		if(flag.equals("registBack"))//注册
		{
			if(msgs[1].equals("True"))
			{
				JOptionPane.showMessageDialog(register.getJf(), "注册成功，请点击返回按钮返回登陆！");
				//界面跳转
//				register.setVisible(false);
//				login.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(register.getJf(), "注册失败，请重试！");
			}
		}
		if(flag.equals("receivePrivatemessage"))//接收私聊
		{
			String acceptid=msgs[1];//接收人id
			String sendid=msgs[2];//发送人id
//			if(acceptid.equals(clientid))//接收人id与自己id相同，就传输数据
				cw.setReceiveMsg(sendid+":"+getNowTime()+":"+msgs[3]);
//			}
		}
		if(flag.equals("receivePublicmessage"))//接收群聊
		{
//			for(int i=3;i<=msgs.length;i++)
//			{
//				if(msgs[i].equals(clientid))
//				{
					gc.setReceiveMsg(msgs[1]+":"+getNowTime()+":"+msgs[3]);//
//					break;
//				}
//			}
		}
		if(flag.equals("getPrivateHistorymessageBack"))//接收私聊历史记录
		{
			
		}
		if(flag.equals("getPublicHistorymessageBack"))//接收群聊历史记录
		{
			
		}
		if(flag.equals("getInfoBack"))//查看的人员的信息
		{   if(msgs[1].equals("false")){
			JOptionPane.showMessageDialog(userMainJFrame.getjFrame(),"查询失败，请输入正确的信息");
		}else {
			usersInfoJFrame.getjLabelRuiQIdText().setText(msgs[1]);
			usersInfoJFrame.getjLabelNickNameText().setText(msgs[3]);
			usersInfoJFrame.getjLabelRealNameText().setText(msgs[2]);
			usersInfoJFrame.getjLabelSexText().setText(msgs[4]);
			usersInfoJFrame.getjLabelEMailText().setText(msgs[5]);
			usersInfoJFrame.getjLabelUserTypeText().setText(msgs[6]);
			usersInfoJFrame.getjFrame().setVisible(true);
		}


		}
		if(flag.equals("getPrivateHistorymessageBack"))//查看私聊聊天记录的信息
		{
			hm.getJf().setVisible(true);
			hm.getChatHistory().append(msgs[2]);
		}

	}
	
	public String changeSexToStr(String str_sex) {
		if(str_sex.equals("0")) {
			str_sex = "女";
		} else if(str_sex.equals("1")) {
			str_sex = "男";
		} 
		return str_sex;
	}
	
	public String changeSexToNumber(String str_sex) {
		if(str_sex.equals("女")) {
			str_sex = "0";
		}
		else if(str_sex.equals("男")) {
			str_sex = "1";
		}
		return str_sex;
	}
	
	public String changeTypeToStr(String str_type) {
		if(str_type.equals("0")) {
			str_type = "管理员";
		}
		else if(str_type.equals("1")) {
			str_type = "普通用户";
		} 
		return str_type;
	}
	
	public String changeTypeToNumber(String str_type) {
		if(str_type.equals("管理员")) {
			str_type = "0";
		}
		else if(str_type.equals("普通用户")) {
			str_type = "1";
		} 
		return str_type;
	}
	public String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(new Date());
	}
	
	
	public static void main(String[] args) {
		try {
			RuiQClient client=new RuiQClient ();
			Thread t=new Thread(client);
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}