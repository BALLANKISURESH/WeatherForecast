package com.virtusa.api;

import java.io.IOException;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * 
 * @author Suresh
 * This class to fetch the data from the server 
 * by using okHttpclient and  the method will return the data 
 * in the JSON format. 
 *
 */
public class ApiRequest {
	public static JSONObject apiCall(String uri) {
		OkHttpClient client;
		Response response;
		client=new OkHttpClient();
		Request request=new Request.Builder()
				.url(uri)
				.build();
		try {
			response =client.newCall(request).execute();
			return new JSONObject(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

}
