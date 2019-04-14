package com.hwua.view;

import java.sql.SQLException;
import java.util.List;
import com.hwua.entity.Record;
import com.hwua.service.IAdminService;
import com.hwua.service.impl.AdminServiceImpl;
import com.hwua.util.InputUtil;

public class AdminCheckRecordView {
	private IAdminService ias = new AdminServiceImpl();
	public void checkRecord() throws SQLException{
		System.out.println("==============>����Ա��ѯ��¼");
		System.out.println("ѡ���ѯ��ʽ��");
		System.out.println("1.��ѯ�����⳵��¼");
		System.out.println("2.�����û���Ų�ѯ�⳵���м�¼");
		System.out.println("3.����������Ų�ѯ�⳵���м�¼");
		int choose = InputUtil.getInt();
		switch(choose){
		case 1:
			List<Record> checkRecordBoth = ias.checkRecordBoth();
			showCarRecord(checkRecordBoth);
			break;
		case 2:
			System.out.println("�������û���ţ�");
			long uuser_u_id = InputUtil.getLong();
			List<Record> checkRecordUserId = ias.checkRecordUserId(uuser_u_id);
			showCarRecord(checkRecordUserId);
			break;
		case 3:
			System.out.println("������������ţ�");
			long car_c_id = InputUtil.getLong();
			List<Record> checkRecordCarId = ias.checkRecordCarId(car_c_id);
			if(checkRecordCarId!=null){
				System.out.println("��ܰ��ʾ:  0:�黹    1:δ�黹");
				System.out.println("���\t�������\t�û����\t�ܶ�\t�⳵ʱ��\t\t����ʱ��\t\t�黹״̬");
				for (Record record : checkRecordCarId) {
					if(record.getR_ifback()==1){
						System.out.println(record.getR_id()+"\t"+record.getCar_c_id()
						+"\t"+record.getUuser_u_id()+"\t"+record.getR_total()+"\t"
								+record.getR_start_date()+"\t"+record.getR_end_date()+"\t\t"
						+record.getR_ifback());
					}else{
						System.out.println(record.getR_id()+"\t"+record.getCar_c_id()
					+"\t"+record.getUuser_u_id()+"\t"+record.getR_total()+"\t"
							+record.getR_start_date()+"\t"+record.getR_end_date()+"\t"
					+record.getR_ifback());
					}
				}
			}
			break;
		}
		
		
	}
	private void showCarRecord(List<Record> checkRecordBoth) {
		if(checkRecordBoth!=null){
			System.out.println("��ܰ��ʾ:  0:�黹    1:δ�黹");
			System.out.println("���\t�������\t�û����\t�ܶ�\t�⳵ʱ��\t\t����ʱ��\t\t�黹״̬");
			for (Record record : checkRecordBoth) {
				if(record.getR_ifback()==1){
					System.out.println(record.getR_id()+"\t"+record.getCar_c_id()
					+"\t"+record.getUuser_u_id()+"\t"+record.getR_total()+"\t"
							+record.getR_start_date()+"\t"+record.getR_end_date()+"\t\t"
					+record.getR_ifback());
				}else{
					System.out.println(record.getR_id()+"\t"+record.getCar_c_id()
				+"\t"+record.getUuser_u_id()+"\t"+record.getR_total()+"\t"
						+record.getR_start_date()+"\t"+record.getR_end_date()+"\t"
				+record.getR_ifback());
				}
				
			}
		}else{
			System.out.println("��ѯʧ�ܣ�");
		}
	}
}
