package com.hwua.rentcar.test;

import java.sql.SQLException;

import com.hwua.view.StartView;

public class Test {
	public static void main(String[] args) {
		StartView start = new StartView();
		try {
			start.start();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
