package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Model;

public class LoginRedirect {
	public static void loginredirect(Model model, String uname) throws ClassNotFoundException{
		String sql = "select username, name from usertable where username='"+uname+"'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","root");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				model.setName(name);
				System.out.println(name);
			}
			connection.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
