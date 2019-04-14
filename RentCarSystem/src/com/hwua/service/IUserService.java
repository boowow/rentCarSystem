package com.hwua.service;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.entity.Record;
import com.hwua.entity.User;

public interface IUserService {
	//登录
	public User login(String username,String password) throws SQLException ;
	
	//注册
	public boolean register(String username,String password) throws SQLException;
	
	//查看汽车信息
	public List<Car> checkCar()throws SQLException;
	
	//按照价格升序查看所有汽车信息
	public List<Car> checkCarUp()throws SQLException;
		
	//按照价格降序查看所有汽车信息
	public List<Car> checkCarLP()throws SQLException;
	
	//按照汽车类型查看所有汽车信息
	public List<Car> checkCarType(String type)throws SQLException;
	
	//按照汽车品牌查看所有汽车信息
	public List<Car> checkCarBrand(String brand)throws SQLException;
	
	//查询通过用户名uuser_u_id租车记录
	public List<Record> checkRecord(long uuser_u_id)throws SQLException;
	
	//租车
	public boolean rentCar(long c_id,long u_id)throws SQLException;
	
	//还车
	public boolean backCar(long c_id,long u_id)throws SQLException;
	
	//通过用户名查询u_id
	public long checkUserID(String u_name)throws SQLException;
	
}
