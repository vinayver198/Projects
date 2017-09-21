package com.cg.brs.util;

public class ValidationUtil {

	public ValidationUtil() {
		// TODO Auto-generated constructor stub
	}

	public static Boolean validateRequest(String email, String sEmail,
			int codeA, int Acode) {
			
		if(email.equalsIgnoreCase(sEmail)== true && (codeA==Acode))
		{
		return true;
	}
		else
			return false;
	}

}
