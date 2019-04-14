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
	//��¼
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
	
	//ע��
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
	
	//�鿴������Ϣ
	@Override
	public List<Car> checkCar() throws SQLException {
		List<Car> list = iCar.checkCar();
		if(list!=null){
			return list;
		}
		return null;
	}
	
	
	//����
	@Override
	public boolean backCar(long c_id,long u_id) throws SQLException {
		//�ж�u_id�û���û����c_id����
		boolean ifrentcar = iRecord.ifrentcar(u_id, c_id);
		//�ж�c_id�����Ƿ��Ѿ���
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

	
	//�鿴�⳵��¼
	@Override
	public List<Record> checkRecord(long uuser_u_id) throws SQLException {
		List<Record> list = iRecord.checkRecord(uuser_u_id);
		if(list!=null){
			return list;
		}
		return null;
	}
	
	//ͨ��������������⳵
	@Override
	public boolean rentCar(long c_id,long u_id) throws SQLException {
		boolean rent = iCar.checkCarIfRent(c_id);  //��ѯ�Ƿ����
		
		boolean putaway = iCar.checkCarIfPutaway(c_id);//��ѯ�Ƿ��ϼ�
		
		if(putaway && rent){
			//�����¼
			int rows = iRecord.insertRecord(c_id, u_id);
			//�޸ĳ���״̬Ϊ������
			int rows2 = iCar.updateCar(c_id,0);
			if(rows>0 && rows2>0){
				return true;
			}
		}
		return false;
		
	}

	//���ռ۸�����鿴����������Ϣ
	@Override
	public List<Car> checkCarUp() throws SQLException {
		List<Car> list = iCar.checkCarUp();
		if(list!=null){
			return list;
		}
		return null;
	}

	//���ռ۸���鿴����������Ϣ
	@Override
	public List<Car> checkCarLP() throws SQLException {
		List<Car> list = iCar.checkCarLP();
		if(list!=null){
			return list;
		}
		return null;
	}

	//�����������鿴����������Ϣ
	@Override
	public List<Car> checkCarType(String type) throws SQLException {
		List<Car> list = iCar.checkCarType(type);
		if(list!=null){
			return list;
		}
		return null;
	}

	//��������Ʒ�Ʋ鿴����������Ϣ
	@Override
	public List<Car> checkCarBrand(String brand) throws SQLException {
		List<Car> list = iCar.checkCarBrand(brand);
		if(list!=null){
			return list;
		}
		return null;
	}

	//ͨ���û�����ѯu_id
	@Override
	public long checkUserID(String u_name) throws SQLException {
		long checkUserId=0;
		if(u_name != null){
			checkUserId = iUser.checkUserId(u_name);
		}
		return checkUserId;
	}

}
