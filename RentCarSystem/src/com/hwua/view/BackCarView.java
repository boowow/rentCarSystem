package com.hwua.view;

import java.sql.SQLException;

import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;

public class BackCarView {
	private IUserService ius = new UserServiceImpl();
	public void backcar(long c_id, long u_id)throws SQLException{
		boolean backCar = ius.backCar(c_id, u_id);
		//System.out.println(backCar);
		if(backCar){
			System.out.println("�����ɹ���");
		}else{
			System.out.println("����ʧ�ܣ�");
		}
	}
}
