package com.hwua.view;

import java.sql.SQLException;

import com.hwua.service.IAdminService;
import com.hwua.service.impl.AdminServiceImpl;
import com.hwua.util.InputUtil;

public class AdminAddCarView {
	private IAdminService ias= new AdminServiceImpl();
	public void addCar() throws SQLException{
		System.out.println("=============>管理员添加汽车");
		System.out.println("请输入汽车名字：");
		String c_name = InputUtil.getString();
		System.out.println("请输入车牌号：");
		String c_carNumber = InputUtil.getString();
		System.out.println("请输入汽车颜色：");
		String c_color = InputUtil.getString();
		System.out.println("请输入汽车价格：");
		long c_carprice = InputUtil.getLong();
		System.out.println("请输入汽车备注：");
		String c_remark = InputUtil.getString();
		System.out.println("请输入汽车品牌：");
		String c_brand = InputUtil.getString();
		System.out.println("请输入汽车类型：");
		String c_type = InputUtil.getString();
		System.out.println("请输入汽车价格/天：");
		long c_price = InputUtil.getLong();
		System.out.println("请输入汽车是否可租：0：不可租  1：可租");
		int c_ifrent = InputUtil.getInt();
		System.out.println("请输入汽车是否上架：0：下架  1：上架");
		int c_ifputaway = InputUtil.getInt();
		int adminAddCar = ias.adminAddCar(c_name, c_carNumber, c_color, c_carprice, 
				c_remark, c_brand, c_type, c_price, c_ifrent, c_ifputaway);
		if(adminAddCar>0){
			System.out.println("添加成功！");
		}else{
			System.out.println("添加失败！");
		}
		
	}
}
