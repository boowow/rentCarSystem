package com.hwua.dao;

import java.sql.SQLException;

import com.hwua.entity.User;

public interface IUser {
	//ͨ������username�鿴���û���Ϣ
	public User checkUser(String username) throws SQLException;
	
	//����û�
	public int addUser(String u_name, String u_password) throws SQLException;
	
	//ͨ���û�����ѯu_id
	public long checkUserId(String u_name)throws SQLException;
	
	
	
	
}
