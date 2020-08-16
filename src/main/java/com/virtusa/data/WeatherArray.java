package com.virtusa.data;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.virtusa.calldata.WeatherServicecall;

public class WeatherArray {

	public static String icon;
	public static String main;
	public static String description;
	/**
	 * 
	 * @throws JSONException
	 * @throws IOException
	 * 
	 * in this only data that are there in the JSON Array that is given by
	 * {@link WeatherServicecall}
	 * and set all the values in the array
	 */
	
	public static  void setWeatherArray() throws JSONException, IOException {
		JSONArray ar= WeatherServicecall.getWeather().getJSONArray("weather");
		for(int i=0;i<ar.length();i++) {
			JSONObject o= ar.getJSONObject(i);
			setIcon(o.getString("icon"));
			setMain(o.getString("main"));
			setDescription(o.getString("description"));
		}
		
	}
	
	//this will return the link to the icon of the weather 
	public static String getIcon() {
		String Icon="http://openweathermap.org/img/wn/";
		Icon+=icon;
		Icon+="@2x.png";
		return Icon;
	}
	public static void setIcon(String icon) {
		WeatherArray.icon = icon;
	}
	public static String getMain() {
		return main;
	}
	public static void setMain(String main) {
		WeatherArray.main = main;
	}
	public static String getDescription() {
		return description;
	}
	public static void setDescription(String description) {
		WeatherArray.description = description;
	}
	

}
