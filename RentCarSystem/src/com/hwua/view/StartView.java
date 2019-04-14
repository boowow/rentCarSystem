package com.hwua.view;

import java.sql.SQLException;

import com.hwua.util.InputUtil;

public class StartView {
	private LoginView lv=new LoginView();
	private RegisterView rv=new RegisterView();
	private AdminLoginView alv = new AdminLoginView();

	public void start() throws SQLException {
		System.out.println("====================================");
		System.out.println("==========欢迎访问海文租车系统=============");
		System.out.println("1.登录  2.注册  3.管理员登录   其他.退出");
		int choose = InputUtil.getInt();
		switch (choose) {
		case 1://登录
			lv.login();
			break;
		case 2://注册
			rv.register();
			break;
		case 3://管理员登录
			alv.login();
			break;
		default:
			System.out.println("退出界面");
			System.exit(0);
			break;
		}
	}
}
