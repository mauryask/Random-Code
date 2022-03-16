/*
 * java regular expressions
 * dealing with the meta characters
 * remember these will give 'false' for=> Pattern.matches(regex, pattern)
 * because here we are using them for searching purpose
 * not to validate a single string pattern
 * you can print the matched subsequence and indices 
*/
package com.pnstech;
import java.util.regex.*;
import static java.lang.System.*;
public class SomeExampleOfRegex
{
	public static void main(String [] args)
	{

	String pattern	 = "forgeeks geeksxpsgeeks iamgeeks";
	String pattern1	 = "geeksfor selfgeeks";
	String pattern2	 = "geeksfor geeks my selfgeeks";
	
	
	//remember that '\b' checks each word of the given input sequence
	//word boundary
	String regex = "geeks\\b"; //it checks at the end of each word
	String regex1 = "\\bgeeks"; //it checks at the beginning of each word
	String regex2 = "\\bgeeks\\b"; //it will search for specific word 'geeks'
	    
	/*=================================================================================*/
	
	//non-word boundary
	// '\B'
	//here in this case the entire pattern (sentence) will be treated as the non-word
	// "\\Bgeeks\\B" this is meaning less here
	String regex3  =  "\\Bgeeks"; //it check at the end of the non-word
	String regex4 = "geeks\\B";  //it check at the beginning of the non-word
	String regex5 = "\\Bgeeks|geeks\\B"; //it searches at beginning and at the end of the given non-word 
	
	/*=============================================================================================*/
	String regex6 = "\\w";  //it checks for word character e.g. [a-zA-Z_0-9] //word can have these only
	
	
	/*=============================================================================================*/
	//here spaces will be treated as the non-word character
	//it will return spaces as the non word character
	String regex7 = "\\W";  //it checks for non-word character e.g. [^\w] 
	String patternx = "Shubham$ ahay1 Priya&";
	
	/*=============================================================================================*/
	String regex8 = "\\d";  //it checks for digits i.e. [0-9] only 
	String patternc = "012Shubham Abhau75";
	
	
	/*=============================================================================================*/
	String regex9 = "geeks";  //it will search for each geeks present in the string (irrespective of boundaries)
	
	
	/*=============================================================================================*/
	String regex10 = "^geeks";  //it will search at the beginning of the line
	String regex11 = "geeks$"; //it will search at the end of the line
	
	
	Pattern p = Pattern.compile(regex11, Pattern.CASE_INSENSITIVE);
	Matcher m = p.matcher(pattern1);
	
	
	  while(m.find())
	  {
		  out.println(m.start());
		  out.println(m.end());
		  out.println(m.group());
	  }
	    
	  
	  
	  /*=============================================================================================*/
	  //here X{1,2} means 1<= n(X) <=2
		String regext = "\\d{1,2}";
		String patternp  = "12";
		String patternq = "5";
		
	out.println(Pattern.matches(regext, patternp)); //it return true;
	out.println(Pattern.matches(regext, patternq)); //it also return true;
	  
	}
}