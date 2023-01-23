package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ShowTable;
import com.model.Model;

/**
 * Servlet implementation class TabeServlet
 */
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Model model = new Model();
		try {
			ShowTable.showtable(model);
			String[] name = model.getArrName();
			model.setArrName(name);
			String[] username = model.getArrUName();
			model.setArrUName(username);
			String[] email = model.getArrEmail();
			model.setArrEmail(email);
			String[] address = model.getArrAddress();
			model.setArrAddress(address);
			String[] city = model.getArrCity();
			model.setArrCity(city);
			String[] country = model.getArrCountry();
			model.setArrCountry(country);
			out.print("<b>User Data Table</b>");
			out.print("<br>");
			out.print("<br>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>Name</th>");
			out.print("<th>Username</th>");
			out.print("<th>Email</th>");
			out.print("<th>Address</th>");
			out.print("<th>City</th>");
			out.print("<th>Country</th>");
			out.print("</tr>");
			for(int i=0;i<=4;i++) {
				out.print("<tr>");
				out.print("<td>"+name[i]+"</td>");
				out.print("<td>"+username[i]+"</td>");
				out.print("<td>"+email[i]+"</td>");
				out.print("<td>"+address[i]+"</td>");
				out.print("<td>"+city[i]+"</td>");
				out.print("<td>"+country[i]+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("datamodel", model);
		request.getRequestDispatcher("table.html").include(request, response);
	}

}
