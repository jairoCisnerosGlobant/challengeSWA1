package com.swacorp.training;


public class ClientDemo {

	public static void main(String ...args){
		   StrategySolver solver = new StrategySolver("Error", "sOME Errors:un error, otro,");
	       StrategyResult result = solver.messageDecode();
	       System.out.println(result.getResponseType());
	       System.out.println(result.getResponseDescription());
	}
}
