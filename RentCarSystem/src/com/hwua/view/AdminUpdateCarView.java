package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.service.IAdminService;
import com.hwua.service.impl.AdminServiceImpl;
import com.hwua.util.InputUtil;

public class AdminUpdateCarView {
	private IAdminService ias= new AdminServiceImpl();
	public void updateCar() throws SQLException{
		System.out.println("=============>管理员修改汽车界面");
		System.out.println("请选择你要修改的操作：");
		System.out.println("1.修改汽车租赁价格，修改汽车上架、下架");
		System.out.println("2.修改汽车租赁价格");
		System.out.println("3.修改汽车上架、下架");
		int choose = InputUtil.getInt();
		
		switch(choose){
		case 1:
			System.out.println("请输入你要修改的汽车编号：");
			long c_id = InputUtil.getLong();
			boolean ifrent = ias.checkCarIfRent(c_id);
			if(ifrent){
				System.out.println("请输入修改后的价格：");
				long c_price = InputUtil.getLong();
				System.out.println("请输入修改后的上架状态：");
				int c_ifputaway = InputUtil.getInt();
				int updateCar = ias.updateCar(c_id, c_price, c_ifputaway);
				if(updateCar>0){
					System.out.println("修改成功！");
				}
			}else{
				System.out.println("该汽车暂不可修改！");
			}
			List<Car> checkCarId = ias.checkCarId(c_id);
			for (Car car : checkCarId) {
				System.out.println("编号\t名字\t车牌号\t颜色\t车价\t备注\t品牌\t类型\t租价\t可租\t上架");
				System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
				+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
						car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
				car.getC_ifrent()+"\t"+car.getC_ifputaway());
			}
			break;
		case 2:
			System.out.println("请输入你要修改的汽车编号：");
			long c_id2 = InputUtil.getLong();
			boolean ifrent2 = ias.checkCarIfRent(c_id2);
			if(ifrent2){
				System.out.println("请输入修改后的价格：");
				long c_price2 = InputUtil.getLong();
				int updateCar = ias.updateCar(c_id2, c_price2);
				if(updateCar>0){
					System.out.println("修改成功！");
				}
			}else{
				System.out.println("该汽车暂不可修改！");
			}
			List<Car> checkCarId2 = ias.checkCarId(c_id2);
			for (Car car : checkCarId2) {
				System.out.println("编号\t名字\t车牌号\t颜色\t车价\t备注\t品牌\t类型\t租价\t可租\t上架");
				System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
				+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
						car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
				car.getC_ifrent()+"\t"+car.getC_ifputaway());
			}
			break;
		case 3:
			System.out.println("请输入你要修改的汽车编号：");
			long c_id3 = InputUtil.getLong();
			boolean ifrent3 = ias.checkCarIfRent(c_id3);
			if(ifrent3){
				System.out.println("请输入修改后的上架状态：");
				int c_ifputaway3 = InputUtil.getInt();
				int updateCar = ias.updateCar(c_id3,c_ifputaway3);
				if(updateCar>0){
					System.out.println("修改成功！");
				}
			}else{
				System.out.println("该汽车暂不可修改！");
			}
			List<Car> checkCarId3 = ias.checkCarId(c_id3);
			for (Car car : checkCarId3) {
				System.out.println("编号\t名字\t车牌号\t颜色\t车价\t备注\t品牌\t类型\t租价\t可租\t上架");
				System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
				+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
						car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
				car.getC_ifrent()+"\t"+car.getC_ifputaway());
			}
			break;
		}
		
	}
}
