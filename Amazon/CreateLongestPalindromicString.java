/*
* T(n) : O(n)
* S(n) : O(n)
** https://www.geeksforgeeks.org/find-longest-palindrome-formed-by-removing-or-shuffling-chars-from-string/
*/
import static java.lang.System.*;
import java.util.*;

public class CreateLongestPalindromicString
{	
    static String getPalin(String str)
	{
		int n = str.length();
		Map<Character, Integer> map = new HashMap<>();
		
		// O(n)
		// Recording the frequencies of every character
		for(int i=0; i<n; i++)
		{
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		// mid character in the palindromic string
		char midChar = '0';
		// size of palindromic string
		int size = 0;
		
		//O(1) : constant time
		for(Map.Entry<Character, Integer> m : map.entrySet())
		{
			char key = m.getKey();
			int val = m.getValue();
		    /*
			* Since in  palindrome every character should be in pair
            * taking only pair of the characters and ignoring the rest			
			*/ 
			// number of pairs * 2 
			// gives the copy of the character that will be present
			// in the palindromic string
			int freq = (val/2)*2; 
			int rem = val % 2;
			size += freq;
			// Any of the extra character could be taken as the 
			// middle character of the palindromic string
			if(rem > 0)
				midChar = key;
			// update the frequencies of the characters
			map.replace(key, freq);			
		}
		
		if(midChar != '0')
			size += 1;
		
		char arr[] = new char[size];
		
		int start = 0;
		int end = size-1;
		
		// O(n)
		//creating the palindromic string
		for(Map.Entry<Character, Integer> m : map.entrySet())
		{
			char key = m.getKey();
			int freq = m.getValue();
			
            while(freq>0)
			{
				arr[start] = key;
				arr[end] = key;
				start++;
				end--;
				freq -= 2;
			}				
		}
		
		// if suizeis of odd length 
		// then there will be a middle character
		if(size %2 == 1)
			arr[start] = midChar;
		// return resulting string
		return String.valueOf(arr);
	}
	
	public static void main(String [] args)
	{
		String str = "abcddc";
		out.println(getPalin(str));
    }
}