package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.LoginRedirect;
import com.model.Model;

/**
 * Servlet implementation class RedirectServlet
 */
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		Model model = new Model();
		model.setUName(uname);
		try {
			LoginRedirect.loginredirect(model, uname);
			String name = model.getName();
			model.setName(name);
			System.out.println(name);
			out.print("Welcome, "+name);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(uname);
		request.setAttribute("datamodel", model);
		request.getRequestDispatcher("link.html").include(request, response);
	}

}
