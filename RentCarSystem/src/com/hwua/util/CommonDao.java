package com.hwua.util;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommonDao {

	public static int exeUpdate(String sql,Object...obj){
		Connection conn = null;
		PreparedStatement pre = null;
		int i =0;
		try {
			conn = ConnectionFactory.getConnection();
			pre = conn.prepareStatement(sql);
			for (int j = 0; j<obj.length;j++) {
				pre.setObject(j+1, obj[j]);
			}
			i =pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(null,pre,conn);
		}
		return i;
	};
	
	public static int exeUpdate(Connection conn,String sql,Object...obj){
		PreparedStatement pre = null;
		int i =0;
		try {
			conn = ConnectionFactory.getConnection();
			pre = conn.prepareStatement(sql);
			for (int j = 0; j<obj.length;j++) {
				pre.setObject(j+1, obj[j]);
			}
			i =pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pre,null);
		}
		return i;
	};
	
	private static <T>T getData(Class<T> T,ResultSet rs){
		try {
			//通过反射获取对象，调用的无参的构造方法
			T t = T.newInstance();
			//获取对象的全部属性，包括public，protected，private
            Field[] fs = T.getDeclaredFields();
            for (Field f:fs) {
            	//暴力反射，强制获取私有信息
                f.setAccessible(true);
                //获取属性类型
                Type type = f.getAnnotatedType().getType();
                String str = type.toString();
    			if (str.contains(".")) {
    				str = str.substring(str.lastIndexOf(".") + 1);
    			}
    			switch (str) {
    			case "int":
    			case "Integer":
    				f.set(t,rs.getInt(f.getName()));
    				break;
    			case "long":
    			case "Long":
    				f.set(t,rs.getLong(f.getName()));
    				break;
    			case "double":
    			case "Double":
    				f.set(t,rs.getDouble(f.getName()));
    				break;
    				
    			default:	
    				f.set(t,rs.getString(f.getName()));
    				break;
    			}
    			
            }
            return t;
        } catch (Exception e) {
            Exception ex = new Exception("数据转换异常");
            ex.printStackTrace();
		}
		return null;
    };
	
	public static <T> List<T> query(Class<T> T,String sql,Object...obj){
		Connection conn = null;
		ArrayList<T> list = new ArrayList<T>(); 
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			pre = conn.prepareStatement(sql);
			for(int i = 0;i<obj.length;i++){
				pre.setObject(i+1,obj[i]);
			}
			rs = pre.executeQuery();
			while(rs.next()){
				list.add(getData(T,rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            ConnectionFactory.close(rs, pre, conn);
		}
		return list;
	}

    public static Integer queryCount(String sql){
        Connection conn =null;
        PreparedStatement pre = null;
        Integer count = 0;
        ResultSet rs = null;
        try {
        	conn = ConnectionFactory.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()){
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	ConnectionFactory.close(rs, pre, conn);
        }
        return count;
    }
}
