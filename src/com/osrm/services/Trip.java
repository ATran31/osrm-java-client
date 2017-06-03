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
 * The trip service solves the Traveling Salesman Problem using a greedy heuristic (farthest-insertion algorithm) for 10 or more waypoints and uses brute force for less than 10 waypoints.
 * The returned path does not have to be the fastest path.
 * As TSP is NP-hard it only returns an approximation.
 * Note that all input coordinates have to be connected for the trip service to work.
 * @author An Tran
 * @see http://project-osrm.org/docs/v5.7.0/api/#trip-service
 * 
 */
public class Trip {

	public Trip(){}

	/**
	 * Solves the Traveling Salesman Problem using the road network and input points.
	 * @param coordinates The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.
	 * @return A JSON object containing the response code, an array of waypoint objects, and an array of route objects.
	 */
	public JSONObject generateTrip(String coordinates) {
		String url = String.format("http://router.project-osrm.org/trip/v1/car/%s?geometries=geojson&overview=full", coordinates);
		HttpClient httpClient = HttpClients.createDefault();
		JSONObject result = null;
		try{
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
	 * Solves the Traveling Salesman Problem using the road network and input points.
	 * @param coordinates The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.
	 * @param profile The mode of travel. Valid values are 'car', 'bike' and 'foot'.
	 * @return A JSON object containing the response code, an array of waypoint objects, and an array of route objects.
	 */
	public JSONObject generateTrip(String coordinates, String profile) {
		String url = String.format("http://router.project-osrm.org/trip/v1/%s/%s?geometries=geojson&overview=full", profile, coordinates);
		HttpClient httpClient = HttpClients.createDefault();
		JSONObject result = null;
		try{
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
