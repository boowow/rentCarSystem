package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;

public interface ICar {
	//�鿴����������Ϣ
	public List<Car> checkCar()throws SQLException;
	
	//���ռ۸�����鿴����������Ϣ
	public List<Car> checkCarUp()throws SQLException;
	
	//���ռ۸���鿴����������Ϣ
	public List<Car> checkCarLP()throws SQLException;
	
	//�����������鿴����������Ϣ
	public List<Car> checkCarType(String type)throws SQLException;
	
	//��������Ʒ�Ʋ鿴����������Ϣ
	public List<Car> checkCarBrand(String brand)throws SQLException;
	
	//�޸ĳ���״̬
	public int updateCar(long c_id,long ifrent)throws SQLException;
	
	//��ѯ�����Ƿ����
	public boolean checkCarIfRent(long c_id)throws SQLException;
	
	//��ѯ�����Ƿ��ϼ�
	public boolean checkCarIfPutaway(long c_id)throws SQLException;
	
	//�������
	public int addCar(Car car)throws SQLException;
	
	//ͨ��������Ų�ѯ����
	public List<Car> checkCarId(long c_id)throws SQLException;
	
	//�޸ĳ���״̬(�޸��������޼۸��޸������ϼܡ��¼�)
	public int updateCar(long c_id,long c_price,int c_ifputaway) throws SQLException;
	
	//�޸ĳ���״̬(�޸��������޼۸��޸������ϼܡ��¼�)
	public int updateCarPrice(long c_id,long c_price) throws SQLException;
	
	//�޸ĳ���״̬(�޸��������޼۸��޸������ϼܡ��¼�)
	public int updateCarPutaway(long c_id,int c_ifputaway) throws SQLException;
	
}
