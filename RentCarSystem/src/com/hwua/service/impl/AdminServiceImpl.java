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
import com.hwua.service.IAdminService;

public class AdminServiceImpl implements IAdminService{
	private IUser iUser = new UserImpl();
	private ICar iCar = new CarImpl();
	private IRecord iRecord = new RecordImpl();

	//�鿴������Ϣ
	@Override
	public List<Car> adminCheckCar() throws SQLException {
		List<Car> list = iCar.checkCar();
		if(list!=null){
			return list;
		}
		return null;
		
	}

	//�鿴���޼�¼
	@Override
	public void adminCheckRecord() {
		// TODO Auto-generated method stub
		
	}
	
	//��¼
	@Override
	public User adminLogin(String adminName,String adminPassword) throws SQLException {
		User user = iUser.checkUser(adminName);
		if(user!=null){
			if(user.getU_name().equals("admin") && adminPassword!=null && adminPassword.equals(user.getU_password())){
				return user;
			}
		}
		return null;
		
		
	}

	//�������
	@Override
	public int adminAddCar(String c_name, String c_carNumber, String c_color, long c_carprice, String c_remark,
			String c_brand, String c_type, long c_price, int c_ifrent, int c_ifputaway) throws SQLException {
		Car car = new Car();
		car.setC_name(c_name);
		car.setC_carNumber(c_carNumber);
		car.setC_color(c_color);
		car.setC_carprice(c_carprice);
		car.setC_remark(c_remark);
		car.setC_brand(c_brand);
		car.setC_type(c_type);
		car.setC_price(c_price);
		car.setC_ifrent(c_ifrent);
		car.setC_ifputaway(c_ifputaway);
		int addCar = new CarImpl().addCar(car);
		if(addCar>0){
			return addCar;
		}
		return 0;
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

	//ͨ��������Ų�ѯ��������
	@Override
	public List<Car> checkCarId(long id) throws SQLException {
		List<Car> list= iCar.checkCarId(id);
		if(list!=null){
			return list;
		}
		return null;
	}

	//�޸ĳ���״̬(�޸��������޼۸��޸������ϼܡ��¼�)
	@Override
	public int updateCar(long c_id, long c_price, int c_ifputaway) throws SQLException {
		int updateCar = iCar.updateCar(c_id, c_price, c_ifputaway);
		if(updateCar>0){
			return updateCar;
		}
		return 0;
	}
	
	//�޸ĳ���״̬(�޸��������޼۸�)
	@Override
	public int updateCar(long c_id, long c_price) throws SQLException {
		int updateCarPrice = iCar.updateCarPrice(c_id, c_price);
		if(updateCarPrice>0){
			return updateCarPrice;
		}
		return 0;
	}
	
	//�޸ĳ���״̬(�޸������ϼܡ��¼�)
	@Override
	public int updateCar(long c_id,int c_ifputaway)throws SQLException{
		int updateCarPrice = iCar.updateCarPutaway(c_id, c_ifputaway);
		if(updateCarPrice>0){
			return updateCarPrice;
		}
		return 0;
	}
	
	//�ж������Ƿ����
	@Override
	public boolean checkCarIfRent(long c_id)throws SQLException{
		boolean rent = iCar.checkCarIfRent(c_id);  //��ѯ�Ƿ����
		return rent;
	}
	
	//��ѯ�����⳵��¼(����Ա)
	@Override
	public List<Record> checkRecordBoth() throws SQLException {
		List<Record> checkRecordBoth = iRecord.checkRecordBoth();
		if(checkRecordBoth!=null){
			return checkRecordBoth;
		}
		return null;
	}

	//�����û���Ų�ѯ�⳵���м�¼(����Ա)
	@Override
	public List<Record> checkRecordUserId(long uuser_u_id) throws SQLException {
		List<Record> checkRecordUserId = iRecord.checkRecordUserId(uuser_u_id);
		if(checkRecordUserId!=null){
			return checkRecordUserId;
		}
		return null;
	}

	//����������Ų�ѯ�⳵���м�¼(����Ա)
	@Override
	public List<Record> checkRecordCarId(long car_c_id) throws SQLException {
		List<Record> checkRecordCarId = iRecord.checkRecordCarId(car_c_id);
		if(checkRecordCarId!=null){
			return checkRecordCarId;
		}
		return null;
	}

	

	


	


}
