package com.osrm.services;

import org.json.JSONObject;

public class TEST {

	public static void main(String[] args) {
		//testRouting();
		//testNearest();
		//testTable();
		//testMatch();
		//testTrip();
	}
	
	private static void testRouting(){
		Route rt = new Route();
		
		// test default routing method
		JSONObject routingDefault = rt.getFastestRoute("-77.0276488,39.0438579;-77.0145167,39.0178761");
		System.out.println("routing default: " + routingDefault.get("code"));
		if (!routingDefault.get("code").equals("Ok")){
			System.out.println(routingDefault.get("message"));
		}
		
		// test routing method with mode of travel
		JSONObject routingWithProfile = rt.getFastestRoute("-77.0276488,39.0438579;-77.0145167,39.0178761", "car");
		System.out.println("routing with profile: " + routingWithProfile.get("code"));
		if (!routingWithProfile.get("code").equals("Ok")){
			System.out.println(routingDefault.get("message"));
		}
	}
	
	private static void testNearest(){
		Nearest n = new Nearest();
		JSONObject nearestDefault = n.findNearestRoute("-77.0276488,39.0438579");
		System.out.println("nearest default: " + nearestDefault.get("code"));
		if (!nearestDefault.get("code").equals("Ok")){
			System.out.println(nearestDefault.get("message"));
		}
		
		JSONObject nearestWithProfile = n.findNearestRoute("-77.0276488,39.0438579", "car");
		System.out.println("nearest with profile: " + nearestWithProfile.get("code"));
		if (!nearestWithProfile.get("code").equals("Ok")){
			System.out.println(nearestWithProfile.get("message"));
		}
		
		JSONObject nearestWithResultCap = n.findNearestRoute("-77.0276488,39.0438579", 3);
		System.out.println("nearest with result cap: " + nearestWithResultCap.get("code"));
		if (!nearestWithResultCap.get("code").equals("Ok")){
			System.out.println(nearestWithResultCap.get("message"));
		}
		
		JSONObject nearestWithAllOptions = n.findNearestRoute("-77.0276488,39.0438579", "car", 3);
		System.out.println("nearest with profile and result cap: " + nearestWithAllOptions.get("code"));
		if (!nearestWithAllOptions.get("code").equals("Ok")){
			System.out.println(nearestWithAllOptions.get("message"));
		}
	}
	
	private static void testTable(){
		Table t = new Table();
		
		JSONObject tableDefault = t.generateTravelTimeMatrix("-77.0276488,39.0438579;-77.0145167,39.0178761");
		System.out.println("table default: " + tableDefault.get("code"));
		if (!tableDefault.get("code").equals("Ok")){
			System.out.println(tableDefault.get("message"));
		}
		
		JSONObject tableWithProfile = t.generateTravelTimeMatrix("-77.0276488,39.0438579;-77.0145167,39.0178761", "car");
		System.out.println("table with profile: " + tableWithProfile.get("code"));
		if (!tableWithProfile.get("code").equals("Ok")){
			System.out.println(tableWithProfile.get("message"));
		}
		
	}
	
	private static void testMatch(){
		Match m = new Match();
		
		JSONObject matchDefault = m.matchPoints("-77.0325407,39.0431791;-77.0003835,38.9847655");
		System.out.println("match default: " + matchDefault.get("code"));
		if (!matchDefault.get("code").equals("Ok")){
			System.out.println(matchDefault.get("message"));
		}
		
		JSONObject matchWithProfile = m.matchPoints("-77.0325407,39.0431791;-77.0003835,38.9847655", "car");
		System.out.println("match with profile: " + matchWithProfile.get("code"));
		if (!matchWithProfile.get("code").equals("Ok")){
			System.out.println(matchWithProfile.get("message"));
		}
	}

	private static void testTrip(){
		Trip tr = new Trip();
		
		JSONObject tripDefault = tr.generateTrip("-77.0276488,39.0438579;-77.0145167,39.0178761");
		System.out.println("trip default: " + tripDefault.get("code"));
		if (!tripDefault.get("code").equals("Ok")){
			System.out.println(tripDefault.get("message"));
		}
		
		JSONObject tripWithProfile = tr.generateTrip("-77.0276488,39.0438579;-77.0145167,39.0178761", "car");
		System.out.println("trip with profile: " + tripWithProfile.get("code"));
		if (!tripWithProfile.get("code").equals("Ok")){
			System.out.println(tripWithProfile.get("message"));
		}
	}
}
