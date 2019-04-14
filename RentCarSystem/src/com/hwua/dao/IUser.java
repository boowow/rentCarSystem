package com.hwua.dao;

import java.sql.SQLException;

import com.hwua.entity.User;

public interface IUser {
	//通过给定username查看该用户信息
	public User checkUser(String username) throws SQLException;
	
	//添加用户
	public int addUser(String u_name, String u_password) throws SQLException;
	
	//通过用户名查询u_id
	public long checkUserId(String u_name)throws SQLException;
	
	
	
	
}
