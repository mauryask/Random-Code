/*
* https://www.geeksforgeeks.org/reduce-the-string-by-removing-k-consecutive-identical-characters/
* Very Imp
* T(n) : O(n)
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class RemoveKConsecutiveDuplicateCharactersFromString
{
	static class Pair
	{
	   char ch;
	   int freq;
	   
	   Pair(char ch, int freq)
	   {
		   this.ch = ch;
		   this.freq = freq;
	   }
	}
	
	static String removeDups(String str, int k)
	{
		if(k==1)
			return "";
		
		Stack<Pair> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++)
		{			   
		   if(!stack.isEmpty() && stack.peek().ch == str.charAt(i))
		   {
			   Pair p = stack.pop();
			   
			   p.freq += 1;
			   
			   if(p.freq != k)
				   stack.push(p);				   
		   }
           else		   
			  stack.push(new Pair(str.charAt(i), 1));
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(Pair p : stack)
		{
			char ch = p.ch;
			int freq = p.freq;
			
			while(freq-->0)
				sb.append(ch);
		}
		
		return sb.toString();
	}
	
	public static void main(String [] args)
	{
       String str =  "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
	   int k = 4;
	   String rsltStr = removeDups(str, k);
	   out.println(rsltStr);
	}
}