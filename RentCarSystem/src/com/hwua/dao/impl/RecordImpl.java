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

	//插入记录
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
	
	//修改记录（设置结束时间，计算总费用，修改归还状态为已归还）
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
	
	//查询c_id对应的价格
	@Override
	public long checkCarPrice(long c_id) throws SQLException{
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_price FROM car WHERE c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, c_id);
		ResultSet rs = pstmt.executeQuery();
		long c_price = 0;
		if(rs.next()) {//如果有 
			c_price = rs.getLong(1);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return c_price;
	}

	//判断u_id用户有没有租c_id汽车
	@Override
	public boolean ifrentcar(long u_id, long c_id) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT uuser_u_id FROM rrecord WHERE car_c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, c_id);
		ResultSet rs = pstmt.executeQuery();
		boolean flag = false;
		if(rs.next()) {//如果有 
			if(rs.getLong(1)==u_id){
				return flag=true;
			}
		}
		ConnectionFactory.close(rs, pstmt, conn);
		
		return false;
	}

	//查询租车记录
	@Override
	public List<Record> checkRecord(long uuser_u_id) throws SQLException {
		List<Record> list = new ArrayList<Record>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_id,car_c_id,uuser_u_id,r_total,r_start_date startdate,r_end_date enddate,r_ifback back FROM rrecord WHERE uuser_u_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, uuser_u_id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {//如果有 
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

	//查询所有租车记录(管理员)
	@Override
	public List<Record> checkRecordBoth() throws SQLException {
		List<Record> list = new ArrayList<Record>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_id,car_c_id,uuser_u_id,r_total,r_start_date startdate,r_end_date enddate,r_ifback back FROM rrecord ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {//如果有 
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

	//按照用户编号查询租车所有记录(管理员)
	@Override
	public List<Record> checkRecordUserId(long uuser_u_id) throws SQLException {
		List<Record> list = new ArrayList<Record>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_id,car_c_id,uuser_u_id,r_total,r_start_date startdate,r_end_date enddate,r_ifback back FROM rrecord WHERE uuser_u_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, uuser_u_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {//如果有 
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

	//按照汽车编号查询租车所有记录(管理员)
	@Override
	public List<Record> checkRecordCarId(long car_c_id) throws SQLException {
		List<Record> list = new ArrayList<Record>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_id,car_c_id,uuser_u_id,r_total,r_start_date startdate,r_end_date enddate,r_ifback back FROM rrecord WHERE car_c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, car_c_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {//如果有 
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
	
	//判断c_id汽车是否已经还
	@Override
	public boolean ifBack(long car_c_id) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT r_ifback FROM rrecord WHERE car_c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, car_c_id);
		ResultSet rs = pstmt.executeQuery();
		boolean flag = false;
		if(rs.next()) {//如果有 
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
