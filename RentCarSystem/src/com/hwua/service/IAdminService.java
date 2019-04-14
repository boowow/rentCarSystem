package com.hwua.service;

import java.sql.SQLException;
import java.util.List;
import com.hwua.entity.Car;
import com.hwua.entity.Record;
import com.hwua.entity.User;

public interface IAdminService {
	//��¼
	public User adminLogin(String adminName,String adminPassword)throws SQLException;
	
	//�鿴������Ϣ
	public List<Car> adminCheckCar()throws SQLException;
	
	//�������
	public int adminAddCar(String c_name,String c_carNumber,String c_color,long c_carprice,String c_remark,String c_brand,String c_type,long c_price,int c_ifrent,int c_ifputaway)throws SQLException;
	
	//�鿴���޼�¼
	public void adminCheckRecord();
	
	//�����������鿴����������Ϣ
	public List<Car> checkCarType(String type) throws SQLException;
	
	//��������Ʒ�Ʋ鿴����������Ϣ
	public List<Car> checkCarBrand(String brand) throws SQLException;
	
	//ͨ��������Ų�ѯ��������
	public List<Car> checkCarId(long id) throws SQLException;
	
	//�޸ĳ���״̬(�޸��������޼۸��޸������ϼܡ��¼�)
	public int updateCar(long c_id,long c_price,int c_ifputaway)throws SQLException;
	
	//�޸ĳ���״̬(�޸��������޼۸�)
	public int updateCar(long c_id,long c_price)throws SQLException;
	
	//�޸ĳ���״̬(�޸������ϼܡ��¼�)
	public int updateCar(long c_id,int c_ifputaway)throws SQLException;

	//�ж������Ƿ����
	public boolean checkCarIfRent(long c_id)throws SQLException;
	
	//��ѯ�����⳵��¼(����Ա)
	public List<Record> checkRecordBoth() throws SQLException;

	//�����û���Ų�ѯ�⳵���м�¼(����Ա)
	public List<Record> checkRecordUserId(long uuser_u_id) throws SQLException;
	
	//����������Ų�ѯ�⳵���м�¼(����Ա)
	public List<Record> checkRecordCarId(long car_c_id) throws SQLException;
}
