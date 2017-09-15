package com.cg.core.pms.util;

import java.util.regex.*;

public class ValidationUtil 
{
	
	public static boolean isNameValid(String name)
	{
		Pattern namePattern = 
				Pattern.compile("[A-Za-z]{3,20}");
		Matcher nameMatcher = namePattern.matcher(name);
		
		if(name==null && name.trim().isEmpty() && !(nameMatcher.matches()))
			return false;
		else
		return true;
	}
	
//	public static boolean isPriceValid(float price)
//	{
//		String pricepattern = "[0-9]{1,}";
//		boolean patternMatched = Pattern.matches(pricepattern, price)
//		if( !(priceMatcher.matches()))
//			return false;
//		else
//		return true;
//	}
	
}
