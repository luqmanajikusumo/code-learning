package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Login;
import com.model.Model;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		Model datamodel = new Model();
		datamodel.setUName(username);
		datamodel.setPassword(password);
		try {
			if(Login.login(datamodel)) {
				request.setAttribute("datamodel", datamodel);
				request.getRequestDispatcher("/RedirectServlet").include(request, response);
			}
			else {
				out.print("username or password is incorrect, try again.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
