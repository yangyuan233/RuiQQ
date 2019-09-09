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
	
	private static List<String> nowclients;//��ǰ��������Ա
	private static Socket client=null;//�ӿ�
	private String clientid;//�Լ���id
	
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
	GroupChat gc= new GroupChat();//Ⱥ�Ľ���
	
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
		//��¼�¼�����
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
		//���ע�ᰴť�¼�
		login.getRegister().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login.getJf().dispose();
				System.out.println("111");
				register.getJf().setVisible(true);
				
			}
		});
		//��ע����������ذ�ť�¼�
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
		//ע������ύ��ť�¼�
		register.getRegist().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(register.getNameTextFiled().getText().equals(""))
				{
					JOptionPane.showMessageDialog(register.getJf(), "�û�������Ϊ��");
				}
				else if(register.getPasswordFiled().getText().equals(""))
				{
					JOptionPane.showMessageDialog(register.getJf(), "���벻��Ϊ��");
				}
				else if(register.getPasswordFiled().getText().length()<6)
				{
					JOptionPane.showMessageDialog(register.getJf(), "����Ӧ�ô��ڵ���6λ");
				}
				else if(!register.getPasswordFiled().getText().equals(register.getSecondPasswordField().getText()))
				{
					JOptionPane.showMessageDialog(register.getJf(), "�������벻ͬ����������");
				}
				else if(!(register.getMailTextFiled().getText().matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")))
				{
					JOptionPane.showMessageDialog(register.getJf(), "��������䲻�Ϸ�");
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


		adminMainJFrame.getjButtonStartChatting().addActionListener(new ActionListener() {//����Ա��������˽�ģ�����˽�Ľ���
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cw.getJf().setVisible(true); //˽�Ĵ���
			}
		});
		userMainJFrame.getjButtonStartChatting().addActionListener(new ActionListener() {//��ͨ�û���������˽�ģ�����˽�Ľ���
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String join = String.join(",", userMainJFrame.getjListUsers().getSelectedValuesList());//�õ�ѡ��id
//				System.out.println(userMainJFrame.getjListUsers().getSelectedValuesList());
				cw.getTargetId().setText(join);
				cw.getJf().setVisible(true);
			}
		});
		userMainJFrame.getjButtonShowOthersInfo().addActionListener(new ActionListener() {//�鿴ѡ���û���Ϣ��Ϣ
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
		adminMainJFrame.getjButtonGroupChatting().addActionListener(new ActionListener() {//����Ա��������Ⱥ�ģ�����Ⱥ�Ľ���
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gc.getJf().setVisible(true); //Ⱥ��
			}
		});
		userMainJFrame.getjButtonGroupChatting().addActionListener(new ActionListener() {//��ͨ�û���������Ⱥ�ģ�����Ⱥ�Ľ���
			@Override
			public void actionPerformed(ActionEvent arg0) {

				gc.setUserList(nowclients);
				gc.addListModelItem();
				gc.flushjListUsers();
				gc.getJf().setVisible(true);

			}
		});
		cw.getSendButton().addActionListener(new ActionListener() {//˽�Ľ��淢��˽����Ϣ
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String armid=cw.getTargetId().getText();//˽�Ľ������.���˽�Ķ����id
				
				String msg="sentPrivateMessage&&"+clientid+"&&"+armid+"&&"+cw.getSendMsg().getText();
				System.out.println(msg);
				cw.setReceiveMsg("��:"+getNowTime()+":"+cw.getSendMsg().getText());
				try {
					SendMessage(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		gc.getHistryMsg().addActionListener(new ActionListener() {//Ⱥ�Ľ����������¼�����������¼����
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hm.setVisible(true);


			}
		});


		gc.getSendButton().addActionListener(new ActionListener() {//Ⱥ�Ľ��淢��Ⱥ����Ϣ
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String msg="sentPublicMessage&&"+clientid+"&&"+gc.getSendMsg().getText()+"";
				gc.setReceiveMsg("��:"+getNowTime()+": "+gc.getSendMsg().getText());

				List<String> list = gc.getUserId();
				if(list.size()==0){
					for(int i=0;i<nowclients.size();i++)//forѭ������Ⱥ���Ҳ�ѡ��Ķ���id,�ӵ�msg��
					{
						msg=msg+"&&"+nowclients.get(i);//���޸�
					}
				}else {
				//���Ⱥ�ĵĶ����id
				for(int i=0;i<list.size();i++)//forѭ������Ⱥ���Ҳ�ѡ��Ķ���id,�ӵ�msg��
				{
					msg=msg+"&&"+list.get(i);//���޸�
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
		userMainJFrame.getjButtonSearch().addActionListener(new ActionListener() {//��ѯ��ť������id������Ϣ
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

		cw.getHistryMsg().addActionListener(new ActionListener() {//˽�Ľ����������¼�����������¼����
			@Override
			public void actionPerformed(ActionEvent e) {
				hm.setVisible(true);
				String armid=cw.getTargetId().getText();//˽�Ľ������.���˽�Ķ����id
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
	//�������Э��
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

	
	public void SendMessage(String msg) throws IOException {//������Ϣ,�����

		new PrintStream(client.getOutputStream()).println(msg);
	}
	public void AcceptiInfo(String str)//��ȡ��Ϣ
	{
		System.out.println(str);
		String[] msgs =str.split("&&");
		String flag =msgs[0];
		if(flag.equals("otherUserLogin"))//�����û����ߣ�
		{
			nowclients.clear();
			for(int i=1;i<msgs.length;i++) {
				nowclients.add(msgs[i]);
			}
			userMainJFrame.setUsersList(nowclients);
			userMainJFrame.flushjListUsers();

			//�޸��������Ⱥ�ĵ���Ա�б�
		}
		if(flag.equals("loginBack"))//��¼
		{
			if(msgs[1].equals("true"))
			{		
				clientid=msgs[2];
				String type=msgs[3];
				if(type.equals("0")) {
					//��ͨ�û�������ʾ
					userMainJFrame.setUsersList(nowclients);
					userMainJFrame.flushjListUsers();
					userMainJFrame.getjFrame().setVisible(true);
					userMainJFrame.getjLabelNickName().setText(msgs[2]);
					login.getJf().dispose();
				}
				else {
					//new����Ա����
					adminMainJFrame.setUsersList(nowclients);
					adminMainJFrame.flushjListUsers();
					adminMainJFrame.getjFrame().setVisible(true);
					adminMainJFrame.getjLabelNickName().setText(msgs[2]);
					login.getJf().dispose();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(login.getJf(), "��¼ʧ��");
			}
		}
		if(flag.equals("registBack"))//ע��
		{
			if(msgs[1].equals("True"))
			{
				JOptionPane.showMessageDialog(register.getJf(), "ע��ɹ����������ذ�ť���ص�½��");
				//������ת
//				register.setVisible(false);
//				login.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(register.getJf(), "ע��ʧ�ܣ������ԣ�");
			}
		}
		if(flag.equals("receivePrivatemessage"))//����˽��
		{
			String acceptid=msgs[1];//������id
			String sendid=msgs[2];//������id
//			if(acceptid.equals(clientid))//������id���Լ�id��ͬ���ʹ�������
				cw.setReceiveMsg(sendid+":"+getNowTime()+":"+msgs[3]);
//			}
		}
		if(flag.equals("receivePublicmessage"))//����Ⱥ��
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
		if(flag.equals("getPrivateHistorymessageBack"))//����˽����ʷ��¼
		{
			
		}
		if(flag.equals("getPublicHistorymessageBack"))//����Ⱥ����ʷ��¼
		{
			
		}
		if(flag.equals("getInfoBack"))//�鿴����Ա����Ϣ
		{   if(msgs[1].equals("false")){
			JOptionPane.showMessageDialog(userMainJFrame.getjFrame(),"��ѯʧ�ܣ���������ȷ����Ϣ");
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
		if(flag.equals("getPrivateHistorymessageBack"))//�鿴˽�������¼����Ϣ
		{
			hm.getJf().setVisible(true);
			hm.getChatHistory().append(msgs[2]);
		}

	}
	
	public String changeSexToStr(String str_sex) {
		if(str_sex.equals("0")) {
			str_sex = "Ů";
		} else if(str_sex.equals("1")) {
			str_sex = "��";
		} 
		return str_sex;
	}
	
	public String changeSexToNumber(String str_sex) {
		if(str_sex.equals("Ů")) {
			str_sex = "0";
		}
		else if(str_sex.equals("��")) {
			str_sex = "1";
		}
		return str_sex;
	}
	
	public String changeTypeToStr(String str_type) {
		if(str_type.equals("0")) {
			str_type = "����Ա";
		}
		else if(str_type.equals("1")) {
			str_type = "��ͨ�û�";
		} 
		return str_type;
	}
	
	public String changeTypeToNumber(String str_type) {
		if(str_type.equals("����Ա")) {
			str_type = "0";
		}
		else if(str_type.equals("��ͨ�û�")) {
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