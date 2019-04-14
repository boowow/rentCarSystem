package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.service.IAdminService;
import com.hwua.service.IUserService;
import com.hwua.service.impl.AdminServiceImpl;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class AdminCheckCar {
	private IAdminService ias = new AdminServiceImpl();
	public void checkCar() throws SQLException{
		System.out.println("请选择查询汽车方式：");
		System.out.println("1.查询全部汽车  2.汽车编号  3.汽车类别  4.汽车品牌  5.添加汽车  6.修改汽车  7.查询租车记录  其他.退出登录");
		int choose = InputUtil.getInt();
		switch(choose){
		case 1:
			//查询全部汽车 
			List<Car> adminCheckCar = ias.adminCheckCar();
			showCarList(adminCheckCar);
			//返回本页面
			checkCar();
			break;
		case 2:
			//汽车编号
			System.out.println("请输入汽车的编号：");
			long id = InputUtil.getLong();
			List<Car> checkCarId = ias.checkCarId(id);
			showCarList(checkCarId);
			//返回本页面
			checkCar();
			break;
		case 3:
			//汽车类别
			System.out.println("请输入汽车类型：");
			String type = InputUtil.getString();
			List<Car> checkCarType = ias.checkCarType(type);
			showCarList(checkCarType);
			//返回本页面
			checkCar();
			break;
		case 4:
			//汽车品牌
			System.out.println("请输入汽车品牌：");
			String brand = InputUtil.getString();
			List<Car> checkCarBrand = ias.checkCarBrand(brand);
			showCarList(checkCarBrand);
			//返回本页面
			checkCar();
			break;
		case 5:
			//添加汽车
			new AdminAddCarView().addCar();
			//返回本页面
			checkCar();
			break;
		case 6:
			//修改汽车
			new AdminUpdateCarView().updateCar();
			//返回本页面
			checkCar();
			break;
		case 7:
			//查询租车记录,进入查询租车记录界面
			new AdminCheckRecordView().checkRecord();
			//返回本页面
			checkCar();
			break;
		default:
			System.exit(0);
			break;
		}
	}
	private void showCarList(List<Car> adminCheckCar) {
		System.out.println("温馨提示: 1:代表可租  0:代表不可租");
			System.out.println("       1:代表上架  0:代表未上架");
		System.out.println("编号\t名字\t车牌号\t颜色\t车价\t备注\t品牌\t类型\t租价\t可租\t上架");
		for (Car car : adminCheckCar) {
			System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
			+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
					car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
			car.getC_ifrent()+"\t"+car.getC_ifputaway());
		}
	}
	
}
