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
	   
	   /*
	   * Purpose of using map is to
	   * keep track of number of unique charcater
	   * in a window
	   */
	   Map<Character, Integer> map = new HashMap<>();
	   
	   while(j<n)
	   {
		   
		   char ch = str.charAt(j);
		   
		   /*
		   * put each character in the map
		   * if character is alrady present 
		   * increase its frequency of the character
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
		  * If size > 'k'  remove charcater 
		  * at i-th index in the string
		  * and increment i
		  * decrese frequency if charcater present in map
		  ******************
		  * At the same time check if frequency of caharacter
		  * is 0 remove it (because it is no longer present
		  * in the existing window), other wise it will give 
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
		
	/*
	* T(n) : O(n*n)
	* S(n) : O(n)
	*/	
	
	static int bruteForce(String str, int n, int k)
	{
		Map<Character, Integer> map = new HashMap<>();;
		int maxLen = 0;	
		
		for(int i=0; i<n; i++)
		{
			if(n-i < k)
				break;
			
			for(int j=i; j<n; j++)
			{
				char ch = str.charAt(j);
				map.put(ch, map.getOrDefault(ch, 0)+1);
				if(map.size() == k)
					maxLen = Math.max(maxLen, j-i+1);
			}
			
			map.clear();
		}
		
		return maxLen;
	}	
		
	public static void main(String [] args)
	{
		String str =  "aabacbebebe";
		int n = str.length();
		int k = 3;
		
		//out.println(maxSubString(str, n, k));
		out.println(bruteForce(str, n, k));
	}
}