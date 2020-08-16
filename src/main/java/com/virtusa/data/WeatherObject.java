package com.virtusa.data;

import java.util.Date;

import org.json.JSONObject;

import com.virtusa.calldata.WeatherServicecall;

/**
 * 
 * @author suresh
 * This class will be to set all the data are in JSON object given by
 * {@link WeatherServicecall}
 *by getWether method 
 * and all setter and getters are used in frond-end to show data
 */
public class WeatherObject {

	public static Object locationcity;
	public static Object locationcountry;
	public static Object temp;
	public static Object pressure;
	public static Object  windSpeed;
	public static Object humidity;
	public static Object min_temp;
	public static Object max_temp;
	public static Object Date;
	public static Object Lng;
	public static Object Lat;



	public static void setWeatherObjects() {
		JSONObject obj=WeatherServicecall.getWeather();
		 Date date = new Date ();
	     date.setTime((long)obj.getInt("dt")*1000);
	     setDate(date);		
		setLocationcity(obj.get("name"));
		setLocationcountry(obj.getJSONObject("sys").get("country"));
		setTemp( obj.getJSONObject("main").get("temp"));
		setPressure( obj.getJSONObject("main").get("pressure"));
		setWindSpeed( obj.getJSONObject("wind").get("speed"));
		setHumidity( obj.getJSONObject("main").get("humidity"));
		setMax_temp( obj.getJSONObject("main").get("temp_max"));
		setMin_temp( obj.getJSONObject("main").get("temp_min"));
		setLng(obj.getJSONObject("coord").get("lon"));
		setLat(obj.getJSONObject("coord").get("lat"));
		
		
		
	}

	
	


	public static Object getLng() {
		return Lng;
	}
	public static void setLng(Object lng) {
		Lng = lng;
	}
	public static Object getLat() {
		return Lat;
	}
	public static void setLat(Object lat) {
		Lat = lat;
	}

	public static Object getDate() {
		return Date;
	}

	public static void setDate(Object date) {
		Date = date;
	}

	public static Object getLocationcity() {
		return locationcity;
	}

	public static void setLocationcity(Object locationcity) {
		WeatherObject.locationcity = locationcity;
	}

	public static Object getLocationcountry() {
		return locationcountry;
	}

	public static void setLocationcountry(Object locationcountry) {
		WeatherObject.locationcountry = locationcountry;
	}

	public static Object getTemp() {
		return temp;
	}

	public static void setTemp(Object temp) {
		WeatherObject.temp = temp;
	}

	public static Object getPressure() {
		return pressure;
	}

	public static void setPressure(Object pressure) {
		WeatherObject.pressure = pressure;
	}

	public static Object getWindSpeed() {
		return windSpeed;
	}

	public static void setWindSpeed(Object windSpeed) {
		WeatherObject.windSpeed = windSpeed;
	}

	public static Object getHumidity() {
		return humidity;
	}

	public static void setHumidity(Object humidity) {
		WeatherObject.humidity = humidity;
	}

	public static Object getMin_temp() {
		return min_temp;
	}

	public static void setMin_temp(Object min_temp) {
		WeatherObject.min_temp = min_temp;
	}

	public static Object getMax_temp() {
		return max_temp;
	}

	public static void setMax_temp(Object max_temp) {
		WeatherObject.max_temp = max_temp;
	}
	
	
	
	

}
