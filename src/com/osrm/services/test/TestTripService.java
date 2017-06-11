package com.osrm.services.test;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

import com.osrm.services.Trip;

public class TestTripService {
	Trip tr = new Trip();
	
	/**
	 * Make request with locations
	 */
	@Test
	public void testDefaultTripRequest(){
	JSONObject tripDefault = tr.generateTrip("-77.0276488,39.0438579;-77.0145167,39.0178761");
	assertEquals("Ok", tripDefault.get("code"));
	}
	
	/**
	 * Make request with locations and mode of travel
	 */
	@Test
	public void testTripRequestWithProfile(){
	JSONObject tripWithProfile = tr.generateTrip("-77.0276488,39.0438579;-77.0145167,39.0178761", "car");
	assertEquals("Ok", tripWithProfile.get("code"));
	}
}
