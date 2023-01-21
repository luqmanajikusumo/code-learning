package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Model;

public class Login {
	public static boolean login(Model login) throws ClassNotFoundException{
		String sql = "select username,password from usertable "
				+ "where username = ? and password = ?";
		boolean status = false; 
		Class.forName("com.mysql.cj.jdbc.Driver");
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","root");
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, login.getUName());
			pstmt.setString(2, login.getPassword());
			ResultSet rs = pstmt.executeQuery();
			status = rs.next();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return status;
	}
}
