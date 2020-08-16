package com.virtusa.data;

import org.json.JSONArray;
import org.json.JSONObject;

import com.virtusa.calldata.WeatherServicecall;
/**
 * 
 * @author suresh
 * This class is for the fetching different parameters in air pollution 
 * To show data in front-end  in a easy manner this class has implemented
 *
 */
public class AirpollutionArray {
/* This parameters will contains values of the airpollution details*/
	public static int AirQualityIndex;
	public static int Con_Of_O3;
	public static int Con_of_SO2;
	public static int Con_of_NO2;
	public static String AirDiscription;
	public static String apicon;
/**
 * This is a method used to set all  the above parameters 
 * by fetching data from JSON object given by api call by
 * {@link WeatherServicecall}
 */
	public static void setAirpollution() {
		JSONArray ar=WeatherServicecall.getAirpollution().getJSONArray("data");
		for(int i=0;i<ar.length();i++) {
			JSONObject o= ar.getJSONObject(i);
			setAirQualityIndex(o.getInt("aqi"));
			setCon_of_NO2(o.getInt("no2"));
			setCon_of_SO2(o.getInt("so2"));
			setCon_Of_O3(o.getInt("o3"));
		}
		//this expressions is for implementing the Air pollution status by aqi(air quality index)
		int check=getAirQualityIndex();
		if(check<=50) {
			setAirDiscription("Good");
			setApicon("&#128516");
		}
		if(check>=51 && check<=100) {
			setAirDiscription("Moderate");
			setApicon("&#128578");
		}
		if(check>=101 && check<=150) {
			setAirDiscription("Unhealthy for Sensitive Groups");
			setApicon("&#128543");
		}
		if(check>=151 && check<=200) {
			setAirDiscription("Unhealthy");
			setApicon("&#128547");
		}
		if(check>=201 && check<=250) {
			setAirDiscription("Very Unhealthy");
			setApicon("&#128544");
		}
		if(check>=251) {
			setAirDiscription("Hazardous");
			setApicon("&#128567");
		}
						
		
	}
	
	
	
	/**
	 * This getters and setters are used 
	 * for all above functions and setters wwill be used in 
	 * Front-end to show the data.
	 * 
	 */
	public static String getApicon() {
		return apicon;
	}

	public static void setApicon(String apicon) {
		AirpollutionArray.apicon = apicon;
	}
	
	public static String getAirDiscription() {
		return AirDiscription;
	}

	public static void setAirDiscription(String airDiscription) {
		AirDiscription = airDiscription;
	}

	public static int getAirQualityIndex() {
		return AirQualityIndex;
	}

	public static void setAirQualityIndex(int airQualityIndex) {
		AirQualityIndex = airQualityIndex;
	}

	public static int getCon_Of_O3() {
		return Con_Of_O3;
	}

	public static void setCon_Of_O3(int con_Of_O3) {
		Con_Of_O3 = con_Of_O3;
	}

	public static int getCon_of_SO2() {
		return Con_of_SO2;
	}

	public static void setCon_of_SO2(int con_of_SO2) {
		Con_of_SO2 = con_of_SO2;
	}

	public static int getCon_of_NO2() {
		return Con_of_NO2;
	}

	public static void setCon_of_NO2(int con_of_NO2) {
		Con_of_NO2 = con_of_NO2;
	}


}
