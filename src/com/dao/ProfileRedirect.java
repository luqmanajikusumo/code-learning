package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Model;

public class ProfileRedirect {
	public static void profileredirect(Model model, String name) throws ClassNotFoundException{
		String sql = "select username, email, address, city, country from usertable where name='"+name+"'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","root");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String country = rs.getString("country");
				model.setName(name);
				model.setUName(username);
				model.setEmail(email);
				model.setAddress(address);
				model.setCity(city);
				model.setCountry(country);
			}
			connection.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
}