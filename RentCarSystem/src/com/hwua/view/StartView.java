package com.hwua.view;

import java.sql.SQLException;

import com.hwua.util.InputUtil;

public class StartView {
	private LoginView lv=new LoginView();
	private RegisterView rv=new RegisterView();
	private AdminLoginView alv = new AdminLoginView();

	public void start() throws SQLException {
		System.out.println("====================================");
		System.out.println("==========��ӭ���ʺ����⳵ϵͳ=============");
		System.out.println("1.��¼  2.ע��  3.����Ա��¼   ����.�˳�");
		int choose = InputUtil.getInt();
		switch (choose) {
		case 1://��¼
			lv.login();
			break;
		case 2://ע��
			rv.register();
			break;
		case 3://����Ա��¼
			alv.login();
			break;
		default:
			System.out.println("�˳�����");
			System.exit(0);
			break;
		}
	}
}
