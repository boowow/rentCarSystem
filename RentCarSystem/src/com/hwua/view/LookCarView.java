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
		System.out.println("��ܰ��ʾ: 1:�������  0:��������");
		System.out.println("���\t����\t���ƺ�\t��ɫ\t����\t��ע\tƷ��\t����\t���\t����");
		for (Car car : list) {
			System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
			+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
					car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
			car.getC_ifrent());
		}
		
	}
}
