package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class CheckCarView {
	private IUserService ius = new UserServiceImpl();
	public void checkCar(String username) throws SQLException{
		System.out.println("============>查询汽车");
		System.out.println("请选择查询方式:");
		System.out.println("1.查询全部汽车  2.升序查询  3.降序查询  4.汽车类别查询  5.汽车品牌查询  其他.退出查询页面");
		Integer choose = InputUtil.getInt();
		switch(choose){
		case 1:
			//查看汽车信息
			List<Car> list = ius.checkCar();
			showCarList(username, list);
			break;
		case 2:
			//按照价格升序查看所有汽车信息
			List<Car> list2 = ius.checkCarUp();
			showCarList(username, list2);
			break;
		case 3:
			//按照价格降序查看所有汽车信息
			List<Car> list3 = ius.checkCarLP();
			showCarList(username, list3);
			break;
		case 4:
			//按照汽车类型查看所有汽车信息
			System.out.println("请输入汽车类型：");
			String type = InputUtil.getString();
			List<Car> list4 = ius.checkCarType(type);
			showCarList(username, list4);
			break;
		case 5:
			//按照汽车品牌查看所有汽车信息
			System.out.println("请输入汽车品牌：");
			String brand = InputUtil.getString();
			List<Car> list5 = ius.checkCarBrand(brand);
			showCarList(username, list5);
			break;
		default:
			//退出登录
			//根据选择确定用户功能
			new SelectFunctionView().select(username);
		}
	}
	private void showCarList(String username, List<Car> list) throws SQLException {
		System.out.println("温馨提示: 1:代表可租  0:代表不可租");
		System.out.println("编号\t名字\t车牌号\t颜色\t车价\t备注\t品牌\t类型\t租价\t可租");
		for (Car car : list) {
			System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
			+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
					car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
			car.getC_ifrent());
		}
		//回到本页面
		checkCar(username);
	}
}
