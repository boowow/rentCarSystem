package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.service.IAdminService;
import com.hwua.service.impl.AdminServiceImpl;
import com.hwua.util.InputUtil;

public class AdminUpdateCarView {
	private IAdminService ias= new AdminServiceImpl();
	public void updateCar() throws SQLException{
		System.out.println("=============>����Ա�޸���������");
		System.out.println("��ѡ����Ҫ�޸ĵĲ�����");
		System.out.println("1.�޸��������޼۸��޸������ϼܡ��¼�");
		System.out.println("2.�޸��������޼۸�");
		System.out.println("3.�޸������ϼܡ��¼�");
		int choose = InputUtil.getInt();
		
		switch(choose){
		case 1:
			System.out.println("��������Ҫ�޸ĵ�������ţ�");
			long c_id = InputUtil.getLong();
			boolean ifrent = ias.checkCarIfRent(c_id);
			if(ifrent){
				System.out.println("�������޸ĺ�ļ۸�");
				long c_price = InputUtil.getLong();
				System.out.println("�������޸ĺ���ϼ�״̬��");
				int c_ifputaway = InputUtil.getInt();
				int updateCar = ias.updateCar(c_id, c_price, c_ifputaway);
				if(updateCar>0){
					System.out.println("�޸ĳɹ���");
				}
			}else{
				System.out.println("�������ݲ����޸ģ�");
			}
			List<Car> checkCarId = ias.checkCarId(c_id);
			for (Car car : checkCarId) {
				System.out.println("���\t����\t���ƺ�\t��ɫ\t����\t��ע\tƷ��\t����\t���\t����\t�ϼ�");
				System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
				+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
						car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
				car.getC_ifrent()+"\t"+car.getC_ifputaway());
			}
			break;
		case 2:
			System.out.println("��������Ҫ�޸ĵ�������ţ�");
			long c_id2 = InputUtil.getLong();
			boolean ifrent2 = ias.checkCarIfRent(c_id2);
			if(ifrent2){
				System.out.println("�������޸ĺ�ļ۸�");
				long c_price2 = InputUtil.getLong();
				int updateCar = ias.updateCar(c_id2, c_price2);
				if(updateCar>0){
					System.out.println("�޸ĳɹ���");
				}
			}else{
				System.out.println("�������ݲ����޸ģ�");
			}
			List<Car> checkCarId2 = ias.checkCarId(c_id2);
			for (Car car : checkCarId2) {
				System.out.println("���\t����\t���ƺ�\t��ɫ\t����\t��ע\tƷ��\t����\t���\t����\t�ϼ�");
				System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
				+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
						car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
				car.getC_ifrent()+"\t"+car.getC_ifputaway());
			}
			break;
		case 3:
			System.out.println("��������Ҫ�޸ĵ�������ţ�");
			long c_id3 = InputUtil.getLong();
			boolean ifrent3 = ias.checkCarIfRent(c_id3);
			if(ifrent3){
				System.out.println("�������޸ĺ���ϼ�״̬��");
				int c_ifputaway3 = InputUtil.getInt();
				int updateCar = ias.updateCar(c_id3,c_ifputaway3);
				if(updateCar>0){
					System.out.println("�޸ĳɹ���");
				}
			}else{
				System.out.println("�������ݲ����޸ģ�");
			}
			List<Car> checkCarId3 = ias.checkCarId(c_id3);
			for (Car car : checkCarId3) {
				System.out.println("���\t����\t���ƺ�\t��ɫ\t����\t��ע\tƷ��\t����\t���\t����\t�ϼ�");
				System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
				+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
						car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
				car.getC_ifrent()+"\t"+car.getC_ifputaway());
			}
			break;
		}
		
	}
}
