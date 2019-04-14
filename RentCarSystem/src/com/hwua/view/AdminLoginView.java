package com.hwua.view;

import java.sql.SQLException;

import com.hwua.entity.User;
import com.hwua.service.IAdminService;
import com.hwua.service.impl.AdminServiceImpl;
import com.hwua.util.InputUtil;

public class AdminLoginView {
	private IAdminService ias = new AdminServiceImpl();
	public void login() throws SQLException {
		System.out.println("==========>管理员登录");
		System.out.print("管理员名：");
		String adminusername = InputUtil.getString();
		System.out.print("管理员密码：");
		String adminpassword = InputUtil.getString();
		User login = ias.adminLogin(adminusername, adminpassword);
		if(login!=null){
			System.out.println("登陆成功！");
			//进入查询汽车界面
			new AdminLookCarView().lookcar();
			new AdminCheckCar().checkCar();
		}else{
			System.out.println("登陆失败！");
			//重新登陆
			login();
		}
		
	}
}
