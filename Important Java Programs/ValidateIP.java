/*
 * IP address validation regex program
 * what is the pattern of the IP
 * A.B.C.D each A,B,C and D ranges from 0-255
 * let A => 
 * */

package com.pnstech;
import java.util.*;
import java.util.regex.Pattern;

import static java.lang.System.*;
public class ValidateIP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ip = sc.next();
		sc.close();
		
		boolean valid = isValid(ip);
		if(valid)
			out.println("Valid");
		else
			out.println("Invalid");

	}
	
	static boolean isValid(String ip)
	{
		
		String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
		String ip_regex = 
				zeroTo255+"\\."+
				zeroTo255+"\\."+
				zeroTo255+"\\."+
				zeroTo255;
		
		boolean valid = Pattern.matches(ip_regex, ip);
		return valid;
	}

}
