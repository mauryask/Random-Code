/*
* T(n) : O(n) 
* S(n) : O(1)
*************
** https://www.geeksforgeeks.org/check-string-substring-another/
*/
import static java.lang.System.*;
import java.util.*;

public class CheckIfAStringIsSubstringOfAnotherString 
{
	static boolean isSubstring(String s1, String s2, 
	int m, int n)
	{
	   int i = 0;
	   
	   while(i<m)
	   {
		   if(s1.charAt(i) == s2.charAt(0))
		   {
			   int j = 0;
			   while(j < n && s1.charAt(i) == s2.charAt(j))
			   {
				   i++; 
				   j++;
			   }
			   
				if(j == n)
					return true;					
		   }
		   else
		     i++;
	   }	
	   
       return false;	   
	}
	
	public static void main(String [] args)
	{
		String s1 = "THIS IS A TEST TEXT";
		String s2 = "TEST";
		int m = s1.length();
		int n = s2.length();
		
		out.println(isSubstring(s1, s2, m, n));
	}
}