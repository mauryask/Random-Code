/*
* Time complexity  : O(n)
* Space complexity : O(n)
***************
** https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
** Variable size window
*/

import static java.lang.System.*;
import java.util.*;

public class MaxSubstringwithKUniqueCharacters
{
	static int maxSubString(String str, int n, int k)
	{
	   int i =0, j=0;
	   /*
	   * if there is no such subtring
	   * having k unique charcates
	   * return -1 itself
	   */
	   int maxLen = -1;
	   
	   Map<Character, Integer> map = new HashMap<>();
	   
	   while(j<n)
	   {
		   
		   char ch = str.charAt(j);
		   
		   /*
		   * put each character in the map
		   * if character is alrady present 
		   * increase its frequency of the chaacter
		   */
		   
		   map.put(ch, map.getOrDefault(ch, 0)+1);
		   
		   /*
		   * Check the size of the map if it is 'k' 
		   * it means three unique 
		   * charcaters are there in the map
		   */
		   
		   if(map.size() == k)
			  maxLen =  Math.max(maxLen, j-i+1);
		  /*
		  * If size > 'k'  remove charcater from 
		  * which is at ith index in the string
		  * and increment i
		  * decrese frequency if charcater present in map
		  ******************
		  * At the same time check if frequency of caharacter
		  * is 0 remove it, other wise it will give 
		  * incorrect number of unique characters 
		  * in a particular window
		  */
		  
		  else if(map.size() > k)
		  {
			  while(map.size() > k)
			  {
				ch =  str.charAt(i);
				map.replace(ch, map.get(ch)-1);
				if(map.get(ch) == 0)
					map.remove(ch);
				i++;  
			  }	
		  }
		  
		  j++;
	   }	

		return maxLen;	   
	}
		
	public static void main(String [] args)
	{
		String str =  "aabacbebebe";
		int n = str.length();
		int k = 3;
		
		out.println(maxSubString(str, n, k));
	}
}