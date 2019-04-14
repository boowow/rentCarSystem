package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.ICar;
import com.hwua.dao.IRecord;
import com.hwua.dao.IUser;
import com.hwua.dao.impl.CarImpl;
import com.hwua.dao.impl.RecordImpl;
import com.hwua.dao.impl.UserImpl;
import com.hwua.entity.Car;
import com.hwua.entity.Record;
import com.hwua.entity.User;
import com.hwua.service.IUserService;

public class UserServiceImpl implements IUserService{
	private IUser iUser = new UserImpl();
	private ICar iCar = new CarImpl();
	private IRecord iRecord = new RecordImpl();
	//登录
	@Override
	public User login(String username, String password) throws SQLException {
		User user = iUser.checkUser(username);
		if(user!=null){
			if(!user.getU_name().equals("admin") && password!=null && password.equals(user.getU_password()) && !user.getU_password().equals("admin")){
				return user;
			}
		}
		return null;
	}
	
	//注册
	@Override
	public boolean register(String username,String password) throws SQLException {
		User user = iUser.checkUser(username);
		if(user == null){
			int rows = iUser.addUser(username, password);
			if(rows>0){
				return true;
			}
		}
		return false;
	}
	
	//查看汽车信息
	@Override
	public List<Car> checkCar() throws SQLException {
		List<Car> list = iCar.checkCar();
		if(list!=null){
			return list;
		}
		return null;
	}
	
	
	//还车
	@Override
	public boolean backCar(long c_id,long u_id) throws SQLException {
		//判断u_id用户有没有租c_id汽车
		boolean ifrentcar = iRecord.ifrentcar(u_id, c_id);
		//判断c_id汽车是否已经还
		boolean ifBack = iRecord.ifBack(c_id);
		if(ifrentcar && ifBack){
			int rows = iRecord.updateRecord(c_id, u_id);
			int rows2 = iCar.updateCar(c_id, 1);
			if(rows>0 && rows2>0){
				return true;
			}
		}
		return false;
		
	}

	
	//查看租车记录
	@Override
	public List<Record> checkRecord(long uuser_u_id) throws SQLException {
		List<Record> list = iRecord.checkRecord(uuser_u_id);
		if(list!=null){
			return list;
		}
		return null;
	}
	
	//通过输入汽车编号租车
	@Override
	public boolean rentCar(long c_id,long u_id) throws SQLException {
		boolean rent = iCar.checkCarIfRent(c_id);  //查询是否可租
		
		boolean putaway = iCar.checkCarIfPutaway(c_id);//查询是否上架
		
		if(putaway && rent){
			//插入记录
			int rows = iRecord.insertRecord(c_id, u_id);
			//修改车的状态为不可租
			int rows2 = iCar.updateCar(c_id,0);
			if(rows>0 && rows2>0){
				return true;
			}
		}
		return false;
		
	}

	//按照价格升序查看所有汽车信息
	@Override
	public List<Car> checkCarUp() throws SQLException {
		List<Car> list = iCar.checkCarUp();
		if(list!=null){
			return list;
		}
		return null;
	}

	//按照价格降序查看所有汽车信息
	@Override
	public List<Car> checkCarLP() throws SQLException {
		List<Car> list = iCar.checkCarLP();
		if(list!=null){
			return list;
		}
		return null;
	}

	//按照汽车类别查看所有汽车信息
	@Override
	public List<Car> checkCarType(String type) throws SQLException {
		List<Car> list = iCar.checkCarType(type);
		if(list!=null){
			return list;
		}
		return null;
	}

	//按照汽车品牌查看所有汽车信息
	@Override
	public List<Car> checkCarBrand(String brand) throws SQLException {
		List<Car> list = iCar.checkCarBrand(brand);
		if(list!=null){
			return list;
		}
		return null;
	}

	//通过用户名查询u_id
	@Override
	public long checkUserID(String u_name) throws SQLException {
		long checkUserId=0;
		if(u_name != null){
			checkUserId = iUser.checkUserId(u_name);
		}
		return checkUserId;
	}

}
