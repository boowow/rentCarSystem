package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Record;
import com.hwua.service.impl.UserServiceImpl;

public class CheckRecordView {
	public void checkRecord(long uuser_u_id) throws SQLException{
		System.out.println("============>查询本用户租车记录");
		List<Record> checkRecord = new UserServiceImpl().checkRecord(uuser_u_id);
		if(checkRecord!=null){
			System.out.println("温馨提示:   0:归还 1:未归还");
			System.out.println("编号\t汽车编号\t用户编号\t总额\t租车时间\t\t还车时间\t\t还车状态");
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
