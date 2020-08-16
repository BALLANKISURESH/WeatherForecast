package com.virtusa.verify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.dao.CredentialsDao;

/**
 * Servlet implementation class verify the password 
 * and get registered to application
 */
public class Veripass extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass1=request.getParameter("upass1");
		String pass2=request.getParameter("upass2");
		CredentialsDao signup =new CredentialsDao();
		try {
			if(pass1.equals(pass2)) {
			 	signup.register(uname, pass1);
				response.sendRedirect("index.jsp");
			}
			else {
			    response.sendRedirect("signup.jsp");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		  response.sendRedirect("index.jsp");
		}
	}

}
