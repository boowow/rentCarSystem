package com.hwua.view;

import java.sql.SQLException;

import com.hwua.entity.User;
import com.hwua.service.IAdminService;
import com.hwua.service.impl.AdminServiceImpl;
import com.hwua.util.InputUtil;

public class AdminLoginView {
	private IAdminService ias = new AdminServiceImpl();
	public void login() throws SQLException {
		System.out.println("==========>����Ա��¼");
		System.out.print("����Ա����");
		String adminusername = InputUtil.getString();
		System.out.print("����Ա���룺");
		String adminpassword = InputUtil.getString();
		User login = ias.adminLogin(adminusername, adminpassword);
		if(login!=null){
			System.out.println("��½�ɹ���");
			//�����ѯ��������
			new AdminLookCarView().lookcar();
			new AdminCheckCar().checkCar();
		}else{
			System.out.println("��½ʧ�ܣ�");
			//���µ�½
			login();
		}
		
	}
}
