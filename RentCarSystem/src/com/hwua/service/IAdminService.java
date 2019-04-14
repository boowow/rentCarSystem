package com.hwua.service;

import java.sql.SQLException;
import java.util.List;
import com.hwua.entity.Car;
import com.hwua.entity.Record;
import com.hwua.entity.User;

public interface IAdminService {
	//登录
	public User adminLogin(String adminName,String adminPassword)throws SQLException;
	
	//查看汽车信息
	public List<Car> adminCheckCar()throws SQLException;
	
	//添加汽车
	public int adminAddCar(String c_name,String c_carNumber,String c_color,long c_carprice,String c_remark,String c_brand,String c_type,long c_price,int c_ifrent,int c_ifputaway)throws SQLException;
	
	//查看租赁记录
	public void adminCheckRecord();
	
	//按照汽车类别查看所有汽车信息
	public List<Car> checkCarType(String type) throws SQLException;
	
	//按照汽车品牌查看所有汽车信息
	public List<Car> checkCarBrand(String brand) throws SQLException;
	
	//通过汽车编号查询所有汽车
	public List<Car> checkCarId(long id) throws SQLException;
	
	//修改车的状态(修改汽车租赁价格，修改汽车上架、下架)
	public int updateCar(long c_id,long c_price,int c_ifputaway)throws SQLException;
	
	//修改车的状态(修改汽车租赁价格)
	public int updateCar(long c_id,long c_price)throws SQLException;
	
	//修改车的状态(修改汽车上架、下架)
	public int updateCar(long c_id,int c_ifputaway)throws SQLException;

	//判断汽车是否可租
	public boolean checkCarIfRent(long c_id)throws SQLException;
	
	//查询所有租车记录(管理员)
	public List<Record> checkRecordBoth() throws SQLException;

	//按照用户编号查询租车所有记录(管理员)
	public List<Record> checkRecordUserId(long uuser_u_id) throws SQLException;
	
	//按照汽车编号查询租车所有记录(管理员)
	public List<Record> checkRecordCarId(long car_c_id) throws SQLException;
}
