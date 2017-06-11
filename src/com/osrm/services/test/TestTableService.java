package com.osrm.services.test;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

import com.osrm.services.Table;

public class TestTableService {
	Table t = new Table();
	
	/**
	 * Make request with only locations
	 */
	@Test
	public void testDefaultTableRequest(){
		JSONObject tableDefault = t.generateTravelTimeMatrix("-77.0276488,39.0438579;-77.0145167,39.0178761");
		assertEquals("Ok", tableDefault.get("code"));
	}

	/**
	 * Make request with locations and mode of travel
	 */
	@Test
	public void testTableRequestWithProfile(){
		JSONObject tableWithProfile = t.generateTravelTimeMatrix("-77.0276488,39.0438579;-77.0145167,39.0178761", "car");
		assertEquals("Ok", tableWithProfile.get("code"));
	}
}
