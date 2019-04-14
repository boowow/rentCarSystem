package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.IUser;
import com.hwua.entity.User;
import com.hwua.util.CommonDao;
import com.hwua.util.ConnectionFactory;

import oracle.net.aso.q;

public class UserImpl implements IUser {
	// 给定username查询用户信息
	@Override
	public User checkUser(String username) throws SQLException {
		 Connection conn = ConnectionFactory.getConnection();
		 String sql = "SELECT u_id,u_name,u_password " +
				 "FROM uuser WHERE u_name=?";
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, username);
		 ResultSet rs = pstmt.executeQuery();
		 User user = null;
		 if(rs.next()) {//如果有
			 user = new User(
				 rs.getLong(1),
				 rs.getString(2),
				 rs.getString(3)
			 );
		 }
		 ConnectionFactory.close(rs, pstmt, conn);
//		String sql = "SELECT u_id,u_name,u_password " + "FROM uuser WHERE u_name=?";
//		List<User> query = CommonDao.query(User.class, sql, username);
//		if (query != null) {
//			return query.get(0);
//		}
		return user;
	}

	// 添加用户
	@Override
	public int addUser(String u_name, String u_password) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "INSERT INTO uuser (u_id,u_name,u_password) " + "VALUES(user_u_id_seq.NEXTVAL,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, u_name);
		pstmt.setString(2, u_password);
		int rows = pstmt.executeUpdate();
		return rows;
	}

	// 通过用户名查询u_id
	@Override
	public long checkUserId(String u_name) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT u_id FROM uuser WHERE u_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, u_name);
		ResultSet rs = pstmt.executeQuery();
		long u_id = 0;
		if (rs.next()) {// 如果有
			u_id = rs.getLong(1);
		}
		ConnectionFactory.close(rs, pstmt, conn);
		return u_id;
	}

}
