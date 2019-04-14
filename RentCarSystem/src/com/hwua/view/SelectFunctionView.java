package com.hwua.view;

import java.sql.SQLException;

import com.hwua.dao.impl.UserImpl;
import com.hwua.util.InputUtil;

public class SelectFunctionView {
	public void select(String username) throws SQLException{
		System.out.println("选择你想要的操作：");
		System.out.println("1.查询汽车  2.租车  3.还车  4.查询租车记录  其他.退出");
		int choose = InputUtil.getInt();
		switch(choose){
		case 1:
			//查询汽车
			new CheckCarView().checkCar(username);
			break;
		case 2:
			//租车 
			System.out.println("输入你要租的车编号：");
			int carId = InputUtil.getInt();
			//查询当前登录用户的u_id
			new RentCarView().rentcar(carId, new UserImpl().checkUserId(username));
			
			select(username);
			break;
		case 3:
			//还车
			System.out.println("输入你要还的车编号：");
			int carnum = InputUtil.getInt();
			new BackCarView().backcar(carnum, new UserImpl().checkUserId(username));
			select(username);
			break;
		case 4:
			//查询租车记录
			new CheckRecordView().checkRecord(new UserImpl().checkUserId(username));
			select(username);
			break;
		default:
			//退出
			System.out.println("退出");
			//退出登录
			break;
		}
	}
}
