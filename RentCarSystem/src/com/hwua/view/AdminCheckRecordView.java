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
		System.out.println("==============>管理员查询记录");
		System.out.println("选择查询方式：");
		System.out.println("1.查询所有租车记录");
		System.out.println("2.按照用户编号查询租车所有记录");
		System.out.println("3.按照汽车编号查询租车所有记录");
		int choose = InputUtil.getInt();
		switch(choose){
		case 1:
			List<Record> checkRecordBoth = ias.checkRecordBoth();
			showCarRecord(checkRecordBoth);
			break;
		case 2:
			System.out.println("请输入用户编号：");
			long uuser_u_id = InputUtil.getLong();
			List<Record> checkRecordUserId = ias.checkRecordUserId(uuser_u_id);
			showCarRecord(checkRecordUserId);
			break;
		case 3:
			System.out.println("请输入汽车编号：");
			long car_c_id = InputUtil.getLong();
			List<Record> checkRecordCarId = ias.checkRecordCarId(car_c_id);
			if(checkRecordCarId!=null){
				System.out.println("温馨提示:  0:归还    1:未归还");
				System.out.println("编号\t汽车编号\t用户编号\t总额\t租车时间\t\t还车时间\t\t归还状态");
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
			System.out.println("温馨提示:  0:归还    1:未归还");
			System.out.println("编号\t汽车编号\t用户编号\t总额\t租车时间\t\t还车时间\t\t归还状态");
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
			System.out.println("查询失败！");
		}
	}
}
