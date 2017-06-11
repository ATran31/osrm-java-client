package com.osrm.services.test;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

import com.osrm.services.Route;

public class TestRoutingService {
	Route rt = new Route();
	
	/**
	 * Make request with only locations
	 */
	@Test
	public void testDefaultRouteRequest(){
		// test default routing method
		JSONObject routingDefault = rt.getFastestRoute("-77.0276488,39.0438579;-77.0145167,39.0178761");
		assertEquals("Ok", routingDefault.get("code"));
	}
	
	/**
	 * Make request with locations and mode of travel
	 */
	@Test
	public void testRouteRequestWithProfile(){
		// test routing method with mode of travel
		JSONObject routingWithProfile = rt.getFastestRoute("-77.0276488,39.0438579;-77.0145167,39.0178761", "car");
		assertEquals("Ok", routingWithProfile.get("code"));
	}
}
