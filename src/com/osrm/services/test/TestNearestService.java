package com.osrm.services.test;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

import com.osrm.services.Nearest;

public class TestNearestService {
	Nearest n = new Nearest();
	
	/**
	 * Make request with only location
	 */
	@Test
	public void testDefaultNearestRequest(){
		JSONObject nearestDefault = n.findNearestRoute("-77.0276488,39.0438579");
		assertEquals("Ok", nearestDefault.get("code"));
	}

	/**
	 * Make request with location and mode of travel
	 */
	@Test
	public void testNearestRequestWithProfile(){
		JSONObject nearestWithProfile = n.findNearestRoute("-77.0276488,39.0438579", "car");
		assertEquals("Ok", nearestWithProfile.get("code"));
	}

	/**
	 * Make request with location and max number of results
	 */
	@Test
	public void testNearestRequesttWithCap(){
		JSONObject nearestWithResultCap = n.findNearestRoute("-77.0276488,39.0438579", 3);
		assertEquals("Ok", nearestWithResultCap.get("code"));
	}

	/**
	 * Make request with location, mode of travel, and max number of results
	 */
	@Test
	public void testNearestRequestWithAllOptions(){
		JSONObject nearestWithAllOptions = n.findNearestRoute("-77.0276488,39.0438579", "car", 3);
		assertEquals("Ok", nearestWithAllOptions.get("code"));
	}
}
