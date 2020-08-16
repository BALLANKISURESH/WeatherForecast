package com.virtusa.weather;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.calldata.WeatherServicecall;
import com.virtusa.data.AirpollutionArray;
import com.virtusa.data.WeatherArray;
import com.virtusa.data.WeatherObject;


/**
 * Servlet implementation class weatherSearvice
 */
public class WeatherServices extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
			String cityName=request.getParameter("city");
			WeatherServicecall.setCity(cityName);
		    WeatherArray.setWeatherArray();//calling to set all parameters in that class.
		    WeatherObject.setWeatherObjects();//calling to set all parameters in that class.
		    AirpollutionArray.setAirpollution();//calling to set all parameters in that class.
			RequestDispatcher rd=request.getRequestDispatcher("data.jsp");
			rd.forward(request, response);
		}
		catch (Exception e) {
			request.setAttribute("check", true);//to help user to enter correct data.
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		
	}

}
