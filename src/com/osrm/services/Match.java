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
 * Map matching matches/snaps given GPS points to the road network in the most plausible way using the Open Source Routing Machine HTTP API.
 * Similar to Nearest except that multiple input points are permitted.
 * @author An Tran
 * @see http://project-osrm.org/docs/v5.7.0/api/#match-service
 * 
 */
public class Match {

	public Match(){}

	/**
	 * Snaps the supplied coordinates to the road network, and returns the most likely route given the points.
	 * @param coordinates The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.
	 * @return A JSON object containing the response code, an array of waypoint objects, and an array of route objects.
	 */
	public JSONObject matchPoints(String coordinates) {
		String url = String.format("http://router.project-osrm.org/match/v1/car/%s?geometries=geojson&overview=full", coordinates);
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
	 * Snaps the supplied coordinates to the road network, and returns the most likely route given the points.
	 * @param coordinates The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.
	 * @param profile The mode of travel. Valid values are 'car', 'bike' and 'foot'.
	 * @return A JSON object containing the response code, an array of waypoint objects, and an array of route objects.
	 */
	public JSONObject matchPoints(String coordinates, String profile) {
		String url = String.format("http://router.project-osrm.org/match/v1/%s/%s?geometries=geojson&overview=full", profile, coordinates);
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
