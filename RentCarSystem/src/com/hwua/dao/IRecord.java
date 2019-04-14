package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Record;

public interface IRecord {
	//插入记录
	public int insertRecord(long c_id,long u_id)throws SQLException;
	
	//修改记录（设置结束时间，计算总费用，修改归还状态为已归还）
	public int updateRecord(long c_id,long u_id) throws SQLException;
	
	//查询c_id对应的价格
	public long checkCarPrice(long c_id)throws SQLException;
	
	//判断u_id用户有没有租c_id汽车
	public boolean ifrentcar(long u_id,long c_id)throws SQLException;
	
	//查询租车记录
	public List<Record> checkRecord(long uuser_u_id)throws SQLException;
	
	//查询租车所有记录(管理员)
	public List<Record> checkRecordBoth()throws SQLException;
	
	//按照用户编号查询租车所有记录(管理员)
	public List<Record> checkRecordUserId(long uuser_u_id)throws SQLException;
	
	//按照汽车编号查询租车所有记录(管理员)
	public List<Record> checkRecordCarId(long uuser_u_id)throws SQLException;
	
	//c_id汽车是否已经还
	public boolean ifBack(long car_c_id) throws SQLException;
	
	
}
