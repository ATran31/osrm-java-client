package com.osrm.services.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestOSRMRunner {

   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(
    		  TestRoutingService.class,
    		  TestNearestService.class,
    		  TestTableService.class,
    		  TestMatchService.class,
    		  TestTripService.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
}
