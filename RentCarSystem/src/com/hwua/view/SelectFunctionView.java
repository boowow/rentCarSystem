package com.hwua.view;

import java.sql.SQLException;

import com.hwua.dao.impl.UserImpl;
import com.hwua.util.InputUtil;

public class SelectFunctionView {
	public void select(String username) throws SQLException{
		System.out.println("ѡ������Ҫ�Ĳ�����");
		System.out.println("1.��ѯ����  2.�⳵  3.����  4.��ѯ�⳵��¼  ����.�˳�");
		int choose = InputUtil.getInt();
		switch(choose){
		case 1:
			//��ѯ����
			new CheckCarView().checkCar(username);
			break;
		case 2:
			//�⳵ 
			System.out.println("������Ҫ��ĳ���ţ�");
			int carId = InputUtil.getInt();
			//��ѯ��ǰ��¼�û���u_id
			new RentCarView().rentcar(carId, new UserImpl().checkUserId(username));
			
			select(username);
			break;
		case 3:
			//����
			System.out.println("������Ҫ���ĳ���ţ�");
			int carnum = InputUtil.getInt();
			new BackCarView().backcar(carnum, new UserImpl().checkUserId(username));
			select(username);
			break;
		case 4:
			//��ѯ�⳵��¼
			new CheckRecordView().checkRecord(new UserImpl().checkUserId(username));
			select(username);
			break;
		default:
			//�˳�
			System.out.println("�˳�");
			//�˳���¼
			break;
		}
	}
}
