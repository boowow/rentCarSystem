package com.hwua.view;

import java.sql.SQLException;

import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class RegisterView {
	private IUserService ius =new UserServiceImpl();
	public void register() throws SQLException{
		System.out.println("==========>ע��");
		System.out.print("�û�����");
		String username = InputUtil.getString();
		System.out.print("���룺");
		String password = InputUtil.getString();
		boolean register = ius.register(username, password);
		if(register){
			System.out.println("ע��ɹ���");
			new StartView().start();
		}else{
			System.out.println("ע��ʧ�ܣ�");
			register();
		}
	}
}
