package com.osrm.services;

import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

/**
 * Roadway finding task that the nearest roadway to a given location using the Open Source Routing HTTP API.
 * @author An Tran
 * @see http://project-osrm.org/docs/v5.7.0/api/#nearest-service
 */
public class Nearest {
	
	public Nearest(){}

	/**
	 * Finds the nearest route to the given location.
	 * @param coordinates The string containing a single comma separated lon/lat pair. Only one coordinate pair is permitted.
	 * @return A JSON object containing the response code, and an array of waypoint objects.
	 * 
	 */
	public JSONObject findNearestRoute(String coordinates) {
		String url = String.format("http://router.project-osrm.org/nearest/v1/car/%s", coordinates);
		HttpClient httpClient = HttpClients.createDefault();
		JSONObject result = null;
		try {
			URIBuilder builder = new URIBuilder(url);
			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);
			request.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(request);
			result = new JSONObject(IOUtils.toString(response.getEntity().getContent()));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}

	/**
	 * Finds the nearest route to the given location, limiting the number of results to a specified number.
	 * @param coordinates The string containing a single comma separated lon/lat pair. Only one coordinate pair is permitted.
	 * @param maxReturns The maximum number of matches to return.
	 * @return A JSON object containing the response code, and an array of waypoint objects.
	 */
	public JSONObject findNearestRoute(String coordinates, int maxReturns) {
		String url = String.format("http://router.project-osrm.org/nearest/v1/car/%s?number=%d", coordinates, maxReturns);
		HttpClient httpClient = HttpClients.createDefault();
		JSONObject result = null;
		try {
			URIBuilder builder = new URIBuilder(url);
			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);
			request.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(request);
			result = new JSONObject(IOUtils.toString(response.getEntity().getContent()));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}	
	
	/**
	 * Finds the nearest route to the given location, accounting for mode of travel.
	 * @param coordinates The string containing a single comma separated lon/lat pair. Only one coordinate pair is permitted.
	 * @param profile The mode of travel. Valid values are 'car', 'bike' and 'foot'.
	 * @return A JSON object containing the response code, and an array of waypoint objects.
	 */
	public JSONObject findNearestRoute(String coordinates, String profile) {
		String url = String.format("http://router.project-osrm.org/nearest/v1/%s/%s", profile, coordinates);
		HttpClient httpClient = HttpClients.createDefault();
		JSONObject result = null;
		try {
			URIBuilder builder = new URIBuilder(url);
			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);
			request.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(request);
			result = new JSONObject(IOUtils.toString(response.getEntity().getContent()));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	/**
	 * Finds the nearest route to the given location, accounting for mode of travel and limiting the number of results to a specified number.
	 * @param coordinates The string containing a single comma separated lon/lat pair. Only one coordinate pair is permitted.
	 * @param profile The mode of travel. Valid values are 'car', 'bike' and 'foot'.
	 * @return A JSON object containing the response code, and an array of waypoint objects.
	 */
	public JSONObject findNearestRoute(String coordinates, String profile, int maxReturns) {
		String url = String.format("http://router.project-osrm.org/nearest/v1/%s/%s?number=%d", profile, coordinates, maxReturns);
		HttpClient httpClient = HttpClients.createDefault();
		JSONObject result = null;
		try {
			URIBuilder builder = new URIBuilder(url);
			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);
			request.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(request);
			result = new JSONObject(IOUtils.toString(response.getEntity().getContent()));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}
}
