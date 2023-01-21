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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		Model model = new Model();
		HttpSession session = request.getSession(true);
		if(session!=null) {
			try {
				ProfileRedirect.profileredirect(model, uname);
				String name = model.getName();
				String email = model.getEmail();
				String address = model.getAddress();
				String city = model.getCity();
				String country = model.getCountry();
				model.setName(name);
				model.setUName(uname);
				model.setEmail(email);
				model.setAddress(address);
				model.setCity(city);
				model.setCountry(country);
				out.println("Profile");
				out.println("Name: "+name);
				out.println("Username: "+uname);
				out.println("Email: "+email);
				out.println("Address: "+address);
				out.println("City: "+city);
				out.println("Country: "+country);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("datamodel", model);
			request.getRequestDispatcher("link.html").include(request, response);
		}
		else {
			out.print("please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}
}
