package com.hwua.service;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.entity.Record;
import com.hwua.entity.User;

public interface IUserService {
	//��¼
	public User login(String username,String password) throws SQLException ;
	
	//ע��
	public boolean register(String username,String password) throws SQLException;
	
	//�鿴������Ϣ
	public List<Car> checkCar()throws SQLException;
	
	//���ռ۸�����鿴����������Ϣ
	public List<Car> checkCarUp()throws SQLException;
		
	//���ռ۸���鿴����������Ϣ
	public List<Car> checkCarLP()throws SQLException;
	
	//�����������Ͳ鿴����������Ϣ
	public List<Car> checkCarType(String type)throws SQLException;
	
	//��������Ʒ�Ʋ鿴����������Ϣ
	public List<Car> checkCarBrand(String brand)throws SQLException;
	
	//��ѯͨ���û���uuser_u_id�⳵��¼
	public List<Record> checkRecord(long uuser_u_id)throws SQLException;
	
	//�⳵
	public boolean rentCar(long c_id,long u_id)throws SQLException;
	
	//����
	public boolean backCar(long c_id,long u_id)throws SQLException;
	
	//ͨ���û�����ѯu_id
	public long checkUserID(String u_name)throws SQLException;
	
}
