package com.hwua.view;

import java.sql.SQLException;

import com.hwua.service.IAdminService;
import com.hwua.service.impl.AdminServiceImpl;
import com.hwua.util.InputUtil;

public class AdminAddCarView {
	private IAdminService ias= new AdminServiceImpl();
	public void addCar() throws SQLException{
		System.out.println("=============>����Ա�������");
		System.out.println("�������������֣�");
		String c_name = InputUtil.getString();
		System.out.println("�����복�ƺţ�");
		String c_carNumber = InputUtil.getString();
		System.out.println("������������ɫ��");
		String c_color = InputUtil.getString();
		System.out.println("�����������۸�");
		long c_carprice = InputUtil.getLong();
		System.out.println("������������ע��");
		String c_remark = InputUtil.getString();
		System.out.println("����������Ʒ�ƣ�");
		String c_brand = InputUtil.getString();
		System.out.println("�������������ͣ�");
		String c_type = InputUtil.getString();
		System.out.println("�����������۸�/�죺");
		long c_price = InputUtil.getLong();
		System.out.println("�����������Ƿ���⣺0��������  1������");
		int c_ifrent = InputUtil.getInt();
		System.out.println("�����������Ƿ��ϼܣ�0���¼�  1���ϼ�");
		int c_ifputaway = InputUtil.getInt();
		int adminAddCar = ias.adminAddCar(c_name, c_carNumber, c_color, c_carprice, 
				c_remark, c_brand, c_type, c_price, c_ifrent, c_ifputaway);
		if(adminAddCar>0){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܣ�");
		}
		
	}
}
