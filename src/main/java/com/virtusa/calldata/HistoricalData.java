package com.virtusa.calldata;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.json.JSONObject;

import com.virtusa.api.ApiRequest;

/**
 * 
 * @author Suresh
 *This class is for historical analytical data access.
 *this will give JSON object of historical data
 *by the Api call with given period and location as a parameter.
 * @link ApiRequest 
 */

public class HistoricalData {

	private static String startdate;
	private static String enddate;
	private static String City;
	/**
	 * Api will take location value as parameter and 
	 * data will be given by ApiRequest.
	 * @return Historical analytical data as JSON object. 
	 */
	
	public static  JSONObject getHistoricalWeather() {
	
		try{
			return ApiRequest.apiCall("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/history?aggregateHours=24&"
					+ "combinationMethod=aggregate&"
					+ "startDateTime="+getStartdate()+"T00%3A00%3A00&"
					+ "endDateTime="+getEnddate()+"T00%3A00%3A00&collectStationContributions=false&maxStations=-1&maxDistance=-1&includeNormals=false&"
					+ "contentType=json&unitGroup=us&locationMode=single&"
					+ "key=2BV9F2FH5YXJBVG7GIC8P4CI9&locations="+getCity()+"%2C%20TG%2C%20in").getJSONObject("location");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * This Getters and Setter
	 * are used for the values of 
	 * location as city, 
	 * begin date as startdate,
	 * last date as end date but as per convenience,
	 * end date will be set to the next day to the start date.
	 * 
	 */
	
	public static String getStartdate() {
		return startdate;
	}
	public static void setStartdate(String startdate) {
		HistoricalData.startdate = startdate;
	}
	public static String getEnddate() {
		return enddate;
	}
	public static void setEnddate(String enddate) {
		HistoricalData.enddate = enddate;
	}
	public static String getCity() {
		return City;
	}
	public static void setCity(String city) {
		City = city;
	}
	
	

	

}
