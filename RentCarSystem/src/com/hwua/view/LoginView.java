package com.hwua.view;

import java.sql.SQLException;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class LoginView {
	private IUserService ius = new UserServiceImpl();
	public void login() throws SQLException {
		System.out.println("==========>登录");
		System.out.print("用户名：");
		String username = InputUtil.getString();
		System.out.print("密码：");
		String password = InputUtil.getString();
		User login = ius.login(username, password);
		if(login!=null){
			System.out.println("登陆成功！");
			//进入查询汽车界面
			new LookCarView().lookcar();
			new CheckCarView().checkCar(username);
		}else{
			System.out.println("登陆失败！");
			//重新登陆
			login();
		}
		
	}
}
