package com.swacorp.training;

import org.apache.commons.lang3.StringUtils;

public class factoryStrategy {
	public static ResponseStrategy getStrategy(String status, String message){
		String fline = StringUtils.substringBefore(message, "\n");
		if(status.equals("COMPLETE")){
			return new CompleteStrategy(status, message);
		}
		else if(StringUtils.substringBefore(message, "\n").contains("Errors")){
			System.out.println("errors");
			return new BunisessExceptionStrategy(status, message);
		}
		else if(fline.contains("xpath=null") && fline.contains("java.lang.NullPointerException")){
			return new BadRequestStrategy(status, message);
		}
		else if(ServerErrorStrategy.isServerError(message)){ 
			return new ServerErrorStrategy(status, message);
		}
		else{
			return null; 
		}
	}

}
