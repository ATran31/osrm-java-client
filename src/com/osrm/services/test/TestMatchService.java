package com.osrm.services.test;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

import com.osrm.services.Match;

public class TestMatchService {
	Match m = new Match();
	
	/**
	 * Make request with locations
	 */
	@Test
	public void testDefaultMatchRequest(){
	JSONObject matchDefault = m.matchPoints("-77.0325407,39.0431791;-77.0003835,38.9847655");
	assertEquals("Ok", matchDefault.get("code"));
	}
	
	/**
	 * Make request with locations and mode of travel
	 */
	@Test
	public void testMatchRequestWithProfile(){
	JSONObject matchWithProfile = m.matchPoints("-77.0325407,39.0431791;-77.0003835,38.9847655", "car");
	assertEquals("Ok", matchWithProfile.get("code"));
	}
}
