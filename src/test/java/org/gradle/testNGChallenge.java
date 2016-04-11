package org.gradle;

import static org.testng.AssertJUnit.assertEquals;
import static org.mockito.Mockito.mock; 
import static org.mockito.Mockito.when; 
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.swacorp.training.SWAMessage;
import com.swacorp.training.StrategyResult;
import com.swacorp.training.StrategySolver;

public class testNGChallenge {
	//mock of the service of the SWA 
	@Mock SWAMessage swaServiceOk;
	@Mock SWAMessage swaServiceOther;
	@Mock SWAMessage swaServiceErrorBusiness;
	
	
	@BeforeClass
	public void create(){
		MockitoAnnotations.initMocks(this);
		//mock message correct
		when(swaServiceOk.getStatus()).thenReturn("COMPLETE");
		when(swaServiceOk.getMessage()).thenReturn("SOME MESSAGE");
		
		//mock a message without suport
		when(swaServiceOther.getStatus()).thenReturn("Other");
		when(swaServiceOther.getMessage()).thenReturn("this is Other message");
		
		//mock error message
		when(swaServiceErrorBusiness.getStatus()).thenReturn("ERROR");
		when(swaServiceErrorBusiness.getMessage()).thenReturn("SOME Errors: this is the business error,");
	}

	@Test
	public void otherResultTest(){
		StrategySolver solver = new StrategySolver(swaServiceOther);
	    StrategyResult result = solver.messageDecode();
	    assertEquals(null, result);
	}
	@Test
	public void completeResultTest(){
		StrategySolver solver = new StrategySolver(swaServiceOk);
	    StrategyResult result = solver.messageDecode();
	    assertEquals("SUCCESSFUL", result.getResponseType());
	}
	@Test
	public void errorBusinessResultTest(){
		StrategySolver solver = new StrategySolver(swaServiceErrorBusiness);
	    StrategyResult result = solver.messageDecode();
	    assertEquals("BUSINESS_ERROR", result.getResponseType());
	}
	@Test(enabled=false)
	public void errorResultTest(){
		StrategySolver solver = new StrategySolver("ERROR", "sOME Errors: this is the business error,");
	    StrategyResult result = solver.messageDecode();
	    assertEquals("BUSINESS_ERROR", result.getResponseType());
	}
}

