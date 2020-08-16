package com.virtusa.weather;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.calldata.HistoricalData;
import com.virtusa.data.HistoricalObject;



/**
 * Servlet implementation class HistoricalDataBetween
 * two different days for forecast.
 */
public class HistoricalDataBetween extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HistoricalData.setStartdate(request.getParameter("date1"));
			HistoricalData.setEnddate(request.getParameter("date2"));
			HistoricalData.setCity(request.getParameter("cityname"));
			HistoricalObject.setHisWeatherArray();		//getting attributes and sety to the parameters
			
			RequestDispatcher rd=request.getRequestDispatcher("historicaldata.jsp"); //redirecting to historical weather forecast page
			rd.forward(request, response);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("check", true);//to help user to enter correct data.
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

}
