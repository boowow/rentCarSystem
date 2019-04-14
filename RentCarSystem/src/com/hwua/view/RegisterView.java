package com.hwua.view;

import java.sql.SQLException;

import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class RegisterView {
	private IUserService ius =new UserServiceImpl();
	public void register() throws SQLException{
		System.out.println("==========>×¢²á");
		System.out.print("ÓÃ»§Ãû£º");
		String username = InputUtil.getString();
		System.out.print("ÃÜÂë£º");
		String password = InputUtil.getString();
		boolean register = ius.register(username, password);
		if(register){
			System.out.println("×¢²á³É¹¦£¡");
			new StartView().start();
		}else{
			System.out.println("×¢²áÊ§°Ü£¡");
			register();
		}
	}
}
