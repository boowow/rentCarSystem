package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Record;

public interface IRecord {
	//�����¼
	public int insertRecord(long c_id,long u_id)throws SQLException;
	
	//�޸ļ�¼�����ý���ʱ�䣬�����ܷ��ã��޸Ĺ黹״̬Ϊ�ѹ黹��
	public int updateRecord(long c_id,long u_id) throws SQLException;
	
	//��ѯc_id��Ӧ�ļ۸�
	public long checkCarPrice(long c_id)throws SQLException;
	
	//�ж�u_id�û���û����c_id����
	public boolean ifrentcar(long u_id,long c_id)throws SQLException;
	
	//��ѯ�⳵��¼
	public List<Record> checkRecord(long uuser_u_id)throws SQLException;
	
	//��ѯ�⳵���м�¼(����Ա)
	public List<Record> checkRecordBoth()throws SQLException;
	
	//�����û���Ų�ѯ�⳵���м�¼(����Ա)
	public List<Record> checkRecordUserId(long uuser_u_id)throws SQLException;
	
	//����������Ų�ѯ�⳵���м�¼(����Ա)
	public List<Record> checkRecordCarId(long uuser_u_id)throws SQLException;
	
	//c_id�����Ƿ��Ѿ���
	public boolean ifBack(long car_c_id) throws SQLException;
	
	
}
