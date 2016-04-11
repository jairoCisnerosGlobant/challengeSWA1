/*
 * @(#)StrategySolver.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;

import java.util.ArrayList;
import java.util.List;

public class StrategySolver {
   private ResponseStrategy strategie;

   public StrategySolver(String status, String message) {
	   initializeStrategy(status, message);
   }
   
   
   public StrategySolver(SWAMessage message) {
	   initializeStrategy(message.getStatus(), message.getMessage());
   }

   public StrategyResult messageDecode() {
	   if(strategie!=null)
		   return strategie.decode();
	   else 
		   return null;
   }

   private void initializeStrategy(String status, String message){
	   strategie=factoryStrategy.getStrategy(status, message);
   }   
}
