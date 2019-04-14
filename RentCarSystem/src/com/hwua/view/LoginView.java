package com.hwua.view;

import java.sql.SQLException;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class LoginView {
	private IUserService ius = new UserServiceImpl();
	public void login() throws SQLException {
		System.out.println("==========>��¼");
		System.out.print("�û�����");
		String username = InputUtil.getString();
		System.out.print("���룺");
		String password = InputUtil.getString();
		User login = ius.login(username, password);
		if(login!=null){
			System.out.println("��½�ɹ���");
			//�����ѯ��������
			new LookCarView().lookcar();
			new CheckCarView().checkCar(username);
		}else{
			System.out.println("��½ʧ�ܣ�");
			//���µ�½
			login();
		}
		
	}
}
