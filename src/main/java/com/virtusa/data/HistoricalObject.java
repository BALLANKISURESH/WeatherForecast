package com.virtusa.data;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.virtusa.calldata.HistoricalData;


/**
 * 
 * @author Suresh
 * This class is to fetch data from the json object from
 * {@link HistoricalData}
 * and convert it to differnt values
 * 
 *
 */

public class HistoricalObject {
	public static Object values;		//this will contain all the data of the list given by period
	public static Object address;		//this will contain location value
	public static Object latitude;
	public static Object longitude;
	
	
	public static  void setHisWeatherArray() throws JSONException, IOException {
		try{JSONObject obj= HistoricalData.getHistoricalWeather();
			setAddress(obj.get("address"));
			setValues(obj.get("values"));	
			setLatitude(obj.get("latitude"));
			setLongitude(obj.get("longitude"));
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}


	public static Object getValues() {
		return values;
	}


	public static void setValues(Object values) {
		HistoricalObject.values = values;
	}


	public static Object getAddress() {
		return address;
	}


	public static void setAddress(Object address) {
		HistoricalObject.address = address;
	}


	public static Object getLatitude() {
		return latitude;
	}


	public static void setLatitude(Object latitude) {
		HistoricalObject.latitude = latitude;
	}


	public static Object getLongitude() {
		return longitude;
	}


	public static void setLongitude(Object longitude) {
		HistoricalObject.longitude = longitude;
	}


	
}


	
