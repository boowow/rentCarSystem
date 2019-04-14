package com.hwua.view;

import com.hwua.service.impl.UserServiceImpl;
import java.sql.SQLException;
import com.hwua.service.IUserService;

public class RentCarView {
	private IUserService ius = new UserServiceImpl();
	public void rentcar(long c_id, long u_id)throws SQLException{
		boolean rentCar = ius.rentCar(c_id, u_id);
		if(rentCar){
			System.out.println("租车成功！");
		}else{
			System.out.println("租车失败！");
		}
	}
}
