package org.gradle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.swacorp.training.StrategyResult;
import com.swacorp.training.StrategySolver;

public class trainingTest {
	
	@Test
	public void otherResultTest(){
		StrategySolver solver = new StrategySolver("OTHER", "sOME MESSAGE");
	    StrategyResult result = solver.messageDecode();
	    assertEquals(null, result);
	}
	@Test
	public void completeResultTest(){
		StrategySolver solver = new StrategySolver("COMPLETE", "sOME MESSAGE");
	    StrategyResult result = solver.messageDecode();
	    assertEquals("SUCCESSFUL", result.getResponseType());
	}
	@Test
	public void errorBusinessResultTest(){
		StrategySolver solver = new StrategySolver("ERROR", "SOME Errors: this is the business error,");
	    StrategyResult result = solver.messageDecode();
	    assertEquals("BUSINESS_ERROR", result.getResponseType());
	}
	@Test
	public void errorResultTest(){
		StrategySolver solver = new StrategySolver("ERROR", "sOME Errors: this is the business error,");
	    StrategyResult result = solver.messageDecode();
	    assertEquals("BUSINESS_ERROR", result.getResponseType());
	}
	
}
