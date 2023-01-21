package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Model;

public class ProfileRedirect {
	public static void profileredirect(Model model, String uname) throws ClassNotFoundException{
		String sql = "select username, name, email, address, city, country from usertable where username='"+uname+"'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","root");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
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
				System.out.println(name);
				System.out.println(username);
				System.out.println(email);
				System.out.println(address);
				System.out.println(city);
				System.out.println(country);
			}
			connection.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
}