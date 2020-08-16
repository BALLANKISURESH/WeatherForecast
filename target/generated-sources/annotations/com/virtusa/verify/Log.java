package com.virtusa.verify;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.dao.CredentialsDao;

/**
 * Servlet implementation from verification of username and password
 */
public class Log extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("upass");
		CredentialsDao dao=new CredentialsDao();
		 try {
			 if(dao.loginVerify(uname, pass)) {
		 
				HttpSession session=request.getSession(); 
				session.setAttribute("username", uname);	//to identify the buser login this session is implemented
				response.sendRedirect("welcome.jsp");
			}
			 else {
				 request.setAttribute("check", true);	//this setAttribute is for notifying the user to enter correct credentials 
				 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				 rd.forward(request, response); 
			 }
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
	}

}
