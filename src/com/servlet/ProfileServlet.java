package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProfileRedirect;
import com.model.Model;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("profile.html").include(request, response);
		HttpSession session = request.getSession(false);
		if(session!=null) {
			String name = (String)session.getAttribute("name");
			Model model = new Model();
			try {
				ProfileRedirect.profileredirect(model, name);
				model.setName(name);
				String username = model.getUName();
				model.setUName(username);
				String email = model.getEmail();
				model.setEmail(email);
				String address = model.getAddress();
				model.setAddress(address);
				String city = model.getCity();
				model.setCity(city);
				String country = model.getCountry();
				model.setCountry(country);
				out.print("<b>Profile</b>");
				out.print("<br>");
				out.print("<br>");
				out.print("Name: "+name);
				out.print("<br>");
				out.print("Username: "+username);
				out.print("<br>");
				out.print("Email: "+email);
				out.print("<br>");
				out.print("Address: "+address);
				out.print("<br>");
				out.print("City: "+city);
				out.print("<br>");
				out.print("Country: "+country);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			out.print("please login first<br><br>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}
}
