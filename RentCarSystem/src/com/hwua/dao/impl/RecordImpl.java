package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hwua.dao.IRecord;
import com.hwua.entity.Record;
import com.hwua.util.ConnectionFactory;

public class RecordImpl implements IRecord{

	//�����¼
	@Override
	public int insertRecord(long c_id,long u_id) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "INSERT INTO rrecord "
				+ "(r_id,car_c_id,uuser_u_id,r_total,r_start_date,r_end_date,r_ifback)"
				+ " VALUES(record_r_id_seq.NEXTVAL,?,?,?,sysdate,null,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, c_id);
		pstmt.setLong(2, u_id);
		pstmt.setLong(3, 0);
		pstmt.setInt(4, 1);
		int rows = pstmt.executeUpdate();
		ConnectionFactory.close(pstmt, conn);
		return rows;
	}
	public static void main(String[] args) {
		/*try {
			new RecordImpl().updateRecord(1,1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			System.out.println(new RecordImpl().checkCarPrice(21));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	//�޸ļ�¼�����ý���ʱ�䣬�����ܷ��ã��޸Ĺ黹״̬Ϊ�ѹ黹��
	@Override
	public int updateRecord(long c_id,long u_id) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "UPDATE rrecord SET r_end_date=sysdate,r_ifback=?,r_total=ceil(sysdate-R_START_DATE)*"+checkCarPrice(c_id)+" WHERE car_c_id=? AND uuser_u_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);
		pstmt.setLong(2, c_id);
		pstmt.setLong(3, u_id);
		int rows = pstmt.executeUpdate();
		ConnectionFactory.close(pstmt, conn);
		return rows;
	}
	
	//��ѯc_id��Ӧ�ļ۸�
	@Override
	public long checkCarPrice(long c_id) throws SQLException{
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_price FROM car WHERE c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, c_id);
		ResultSet rs = pstmt.executeQuery();
		long c_price = 0;
		if(rs.next()) {//����� 
			c_price = rs.getLong(1);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return c_price;
	}

	//�ж�u_id�û���û����c_id����
	@Override
	public boolean ifrentcar(long u_id, long c_id) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT uuser_u_id FROM rrecord WHERE car_c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, c_id);
		ResultSet rs = pstmt.executeQuery();
		boolean flag = false;
		if(rs.next()) {//����� 
			if(rs.getLong(1)==u_id){
				return flag=true;
			}
		}
		ConnectionFactory.close(rs, pstmt, conn);
		
		return false;
	}

	//��ѯ�⳵��¼
	@Override
	public List<Record> checkRecord(long uuser_u_id) throws SQLException {
		List<Record> list = new ArrayList<Record>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_id,car_c_id,uuser_u_id,r_total,r_start_date startdate,r_end_date enddate,r_ifback back FROM rrecord WHERE uuser_u_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, uuser_u_id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {//����� 
			Record record = new Record(
					rs.getLong(1),
					rs.getLong(2),
					rs.getLong(3),
					rs.getLong(4),
					rs.getDate("startdate"),
					rs.getDate("enddate"),
					rs.getInt("back")
					);
			list.add(record);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}

	//��ѯ�����⳵��¼(����Ա)
	@Override
	public List<Record> checkRecordBoth() throws SQLException {
		List<Record> list = new ArrayList<Record>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_id,car_c_id,uuser_u_id,r_total,r_start_date startdate,r_end_date enddate,r_ifback back FROM rrecord ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {//����� 
			Record record = new Record(
					rs.getLong(1),
					rs.getLong(2),
					rs.getLong(3),
					rs.getLong(4),
					rs.getDate("startdate"),
					rs.getDate("enddate"),
					rs.getInt("back")
					);
			list.add(record);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}

	//�����û���Ų�ѯ�⳵���м�¼(����Ա)
	@Override
	public List<Record> checkRecordUserId(long uuser_u_id) throws SQLException {
		List<Record> list = new ArrayList<Record>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_id,car_c_id,uuser_u_id,r_total,r_start_date startdate,r_end_date enddate,r_ifback back FROM rrecord WHERE uuser_u_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, uuser_u_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {//����� 
			Record record = new Record(
					rs.getLong(1),
					rs.getLong(2),
					rs.getLong(3),
					rs.getLong(4),
					rs.getDate("startdate"),
					rs.getDate("enddate"),
					rs.getInt("back")
					);
			list.add(record);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}

	//����������Ų�ѯ�⳵���м�¼(����Ա)
	@Override
	public List<Record> checkRecordCarId(long car_c_id) throws SQLException {
		List<Record> list = new ArrayList<Record>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_id,car_c_id,uuser_u_id,r_total,r_start_date startdate,r_end_date enddate,r_ifback back FROM rrecord WHERE car_c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, car_c_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {//����� 
			Record record = new Record(
					rs.getLong(1),
					rs.getLong(2),
					rs.getLong(3),
					rs.getLong(4),
					rs.getDate("startdate"),
					rs.getDate("enddate"),
					rs.getInt("back")
					);
			list.add(record);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}
	
	//�ж�c_id�����Ƿ��Ѿ���
	@Override
	public boolean ifBack(long car_c_id) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_ifback FROM rrecord WHERE car_c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, car_c_id);
		ResultSet rs = pstmt.executeQuery();
		boolean flag = false;
		if(rs.next()) {//����� 
			int r_ifback = rs.getInt(1);
			if(r_ifback==1){
				flag = true;
			}
		}
		ConnectionFactory.close(rs, pstmt, conn);
		if(flag){
			return flag;
		}
		return false;
	}
	

}
