package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Record;
import com.hwua.service.impl.UserServiceImpl;

public class CheckRecordView {
	public void checkRecord(long uuser_u_id) throws SQLException{
		System.out.println("============>��ѯ���û��⳵��¼");
		List<Record> checkRecord = new UserServiceImpl().checkRecord(uuser_u_id);
		if(checkRecord!=null){
			System.out.println("��ܰ��ʾ:   0:�黹 1:δ�黹");
			System.out.println("���\t�������\t�û����\t�ܶ�\t�⳵ʱ��\t\t����ʱ��\t\t����״̬");
			for (Record record : checkRecord) {
				if(record.getR_ifback()==1){
					System.out.println(record.getR_id()+"\t"+record.getCar_c_id()+"\t"
							+record.getUuser_u_id()+"\t"+record.getR_total()+"\t"+record.getR_start_date()
							+"\t"+record.getR_end_date()+"\t\t"+record.getR_ifback());
				}else{
					System.out.println(record.getR_id()+"\t"+record.getCar_c_id()+"\t"
			+record.getUuser_u_id()+"\t"+record.getR_total()+"\t"+record.getR_start_date()
			+"\t"+record.getR_end_date()+"\t"+record.getR_ifback());
				}
			}
		}
		
		
	}
}
