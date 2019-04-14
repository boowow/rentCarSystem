package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;

public interface ICar {
	//查看所有汽车信息
	public List<Car> checkCar()throws SQLException;
	
	//按照价格升序查看所有汽车信息
	public List<Car> checkCarUp()throws SQLException;
	
	//按照价格降序查看所有汽车信息
	public List<Car> checkCarLP()throws SQLException;
	
	//按照汽车类别查看所有汽车信息
	public List<Car> checkCarType(String type)throws SQLException;
	
	//按照汽车品牌查看所有汽车信息
	public List<Car> checkCarBrand(String brand)throws SQLException;
	
	//修改车的状态
	public int updateCar(long c_id,long ifrent)throws SQLException;
	
	//查询汽车是否可租
	public boolean checkCarIfRent(long c_id)throws SQLException;
	
	//查询汽车是否上架
	public boolean checkCarIfPutaway(long c_id)throws SQLException;
	
	//添加汽车
	public int addCar(Car car)throws SQLException;
	
	//通过汽车编号查询汽车
	public List<Car> checkCarId(long c_id)throws SQLException;
	
	//修改车的状态(修改汽车租赁价格，修改汽车上架、下架)
	public int updateCar(long c_id,long c_price,int c_ifputaway) throws SQLException;
	
	//修改车的状态(修改汽车租赁价格，修改汽车上架、下架)
	public int updateCarPrice(long c_id,long c_price) throws SQLException;
	
	//修改车的状态(修改汽车租赁价格，修改汽车上架、下架)
	public int updateCarPutaway(long c_id,int c_ifputaway) throws SQLException;
	
}
