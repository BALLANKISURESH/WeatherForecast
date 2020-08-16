package com.virtusa.verify;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session=request.getSession();
			session.removeAttribute("username");
			session.invalidate();				//this remove session and helps to stop retried data when user is log out
			response.sendRedirect("index.jsp");
		}catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("index.jsp");
		}
	}

}
