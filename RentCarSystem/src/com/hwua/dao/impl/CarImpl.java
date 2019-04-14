package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hwua.dao.ICar;
import com.hwua.entity.Car;
import com.hwua.util.ConnectionFactory;

public class CarImpl implements ICar{
	//查询全部汽车(上架的)
	@Override
	public List<Car> checkCar() throws SQLException {
		List<Car> list = new ArrayList<Car>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_id,c_name,c_carNumber," +
		  		"c_color,c_carprice,c_remark,c_brand,c_type," +
		  		"c_price,c_ifrent,c_ifputaway FROM car WHERE c_ifputaway=1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		Car car=null;
		while(rs.next()) {//如果有 
			car = new Car(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getLong(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getLong(9),
					rs.getInt(10),
					rs.getInt(11)
					);
			list.add(car);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}

	//按照价格升序查看所有汽车信息
	@Override
	public List<Car> checkCarUp() throws SQLException {
		List<Car> list = new ArrayList<Car>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_id,c_name,c_carNumber," +
		  		"c_color,c_carprice,c_remark,c_brand,c_type," +
		  		"c_price,c_ifrent,c_ifputaway FROM car WHERE c_ifputaway=1 ORDER BY c_price";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		Car car=null;
		while(rs.next()) {//如果有 
			car = new Car(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getLong(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getLong(9),
					rs.getInt(10),
					rs.getInt(11)
					);
			list.add(car);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}

	//按照价格降序查看所有汽车信息
	@Override
	public List<Car> checkCarLP() throws SQLException {
		List<Car> list = new ArrayList<Car>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_id,c_name,c_carNumber," +
		  		"c_color,c_carprice,c_remark,c_brand,c_type," +
		  		"c_price,c_ifrent,c_ifputaway FROM car WHERE c_ifputaway=1 ORDER BY c_price DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		Car car=null;
		while(rs.next()) {//如果有 
			car = new Car(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getLong(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getLong(9),
					rs.getInt(10),
					rs.getInt(11)
					);
			list.add(car);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}

	//按照汽车类型查看所有汽车信息
	@Override
	public List<Car> checkCarType(String type) throws SQLException {
		List<Car> list = new ArrayList<Car>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_id,c_name,c_carNumber," +
		  		"c_color,c_carprice,c_remark,c_brand,c_type," +
		  		"c_price,c_ifrent,c_ifputaway FROM car WHERE c_ifputaway=1 AND c_type=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, type);
		ResultSet rs = pstmt.executeQuery();
		Car car=null;
		while(rs.next()) {//如果有 
			car = new Car(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getLong(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getLong(9),
					rs.getInt(10),
					rs.getInt(11)
					);
			list.add(car);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}

	//按照汽车品牌查看所有汽车信息
	@Override
	public List<Car> checkCarBrand(String brand) throws SQLException {
		List<Car> list = new ArrayList<Car>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_id,c_name,c_carNumber," +
		  		"c_color,c_carprice,c_remark,c_brand,c_type," +
		  		"c_price,c_ifrent,c_ifputaway FROM car WHERE c_ifputaway=1 AND c_brand=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,brand);
		ResultSet rs = pstmt.executeQuery();
		Car car=null;
		while(rs.next()) {//如果有 
			car = new Car(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getLong(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getLong(9),
					rs.getInt(10),
					rs.getInt(11)
					);
			list.add(car);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}
	
	
	//修改车的状态(是否可租)
	@Override
	public int updateCar(long c_id,long ifrent) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "UPDATE car SET c_ifrent=? WHERE c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, ifrent);
		pstmt.setLong(2, c_id);
		int rows = pstmt.executeUpdate();
		ConnectionFactory.close(pstmt, conn);
		return rows;
		
	}

	//查询汽车是否可租
	@Override
	public boolean checkCarIfRent(long c_id) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_ifrent FROM car WHERE c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, c_id);;
		ResultSet rs = pstmt.executeQuery();
		int ifrent = 0;
		if(rs.next()){
			ifrent = rs.getInt(1);
		}
		if(ifrent==1){
			return true;
		}
		return false;
	}

	//查询汽车是否上架
	@Override
	public boolean checkCarIfPutaway(long c_id)throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_ifputaway FROM car WHERE c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, c_id);;
		ResultSet rs = pstmt.executeQuery();
		int ifrent = 0;
		if(rs.next()){
			ifrent = rs.getInt(1);
		}
		if(ifrent==1){
			return true;
		}
		return false;
	}
	
	//添加汽车
	@Override
	public int addCar(Car car) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "INSERT INTO car "
				+ "(c_id,c_name,c_carNumber,c_color,c_carprice,"
				+ "c_remark,c_brand,c_type,c_price,c_ifrent,c_ifputaway)"
				+ " VALUES(car_c_id_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, car.getC_name());
		pstmt.setString(2, car.getC_carNumber());
		pstmt.setString(3, car.getC_color());
		pstmt.setLong(4, car.getC_carprice());
		pstmt.setString(5, car.getC_remark());
		pstmt.setString(6, car.getC_brand());
		pstmt.setString(7, car.getC_type());
		pstmt.setLong(8, car.getC_price());
		pstmt.setInt(9, car.getC_ifrent());
		pstmt.setInt(10, car.getC_ifputaway());

		int rows = pstmt.executeUpdate();
		ConnectionFactory.close(pstmt, conn);
		return rows;
	}

	//通过汽车编号查询汽车
	@Override
	public List<Car> checkCarId(long c_id) throws SQLException {
		List<Car> list = new ArrayList<Car>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT c_id,c_name,c_carNumber," +
		  		"c_color,c_carprice,c_remark,c_brand,c_type," +
		  		"c_price,c_ifrent,c_ifputaway FROM car WHERE c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1,c_id);
		ResultSet rs = pstmt.executeQuery();
		Car car=null;
		while(rs.next()) {//如果有 
			car = new Car(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getLong(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getLong(9),
					rs.getInt(10),
					rs.getInt(11)
					);
			list.add(car);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return list;
	}
	
	//修改车的状态(修改汽车租赁价格，修改汽车上架、下架)
	@Override
	public int updateCar(long c_id,long c_price,int c_ifputaway) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "UPDATE car SET c_price=?,c_ifputaway=? WHERE c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, c_price);
		pstmt.setInt(2, c_ifputaway);
		pstmt.setLong(3, c_id);
		int rows = pstmt.executeUpdate();
		ConnectionFactory.close(pstmt, conn);
		return rows;
		
	}

	//修改车的状态(修改汽车租赁价格)
	@Override
	public int updateCarPrice(long c_id, long c_price) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "UPDATE car SET c_price=? WHERE c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, c_price);
		pstmt.setLong(2, c_id);
		int rows = pstmt.executeUpdate();
		ConnectionFactory.close(pstmt, conn);
		return rows;
	}

	//修改车的状态(修改汽车上架、下架)
	@Override
	public int updateCarPutaway(long c_id, int c_ifputaway) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "UPDATE car SET c_ifputaway=? WHERE c_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, c_ifputaway);
		pstmt.setLong(2, c_id);
		int rows = pstmt.executeUpdate();
		ConnectionFactory.close(pstmt, conn);
		return rows;
	}
	
	

	
	
	
	
}
