package com.virtusa.calldata;


import org.json.JSONObject;
import com.virtusa.api.ApiRequest;
/**
 * 
 * @author Suresh
 * This class is for fetching the present weather and air pollution details
 * for weather details getWeather method will be accessed and 
 * for air pollution details getAirpolltion methods will be use-full.
 * @link ApiRequest
 *
 */

public class WeatherServicecall {

	private static String city;
	/**
	 *This method will fetch data by using parameters 
	 * of location value as city.
	 * @return weather Details in JSON format. 
	 */
	public static  JSONObject getWeather() {		
		
		try{
			return ApiRequest.apiCall("http://api.openweathermap.org/data/2.5/weather?"
		
						+ "q="+getCity()+"&"
						+ "units=metric&"
						+ "appid=725d5226b0206eab11a4538745e8b31e");		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * this method will fetch data by using parameters 
	 * of location value as city.
	 * @return Air pollution data in JSON format.
	 */
	public static  JSONObject getAirpollution() {
		try{
			return ApiRequest.apiCall("https://api.weatherbit.io/v2.0/current/airquality?&"
							+ "city="+getCity()+""
							+ "&key=29a4856c577e40289b95d01375837fbe");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * this getters and setter is for location
	 * value to be in api call. 
	 */
	public static String getCity() {
		return city;
	}
	public static void setCity(String city) {
		WeatherServicecall.city = city;
	}


	
	
	
	
	
}
