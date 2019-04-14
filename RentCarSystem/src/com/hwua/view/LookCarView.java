package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;

public class LookCarView {
	public void lookcar() throws SQLException{
		IUserService ius = new UserServiceImpl();
		List<Car> list = ius.checkCar();
		System.out.println("温馨提示: 1:代表可租  0:代表不可租");
		System.out.println("编号\t名字\t车牌号\t颜色\t车价\t备注\t品牌\t类型\t租价\t可租");
		for (Car car : list) {
			System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
			+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
					car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
			car.getC_ifrent());
		}
		
	}
}
