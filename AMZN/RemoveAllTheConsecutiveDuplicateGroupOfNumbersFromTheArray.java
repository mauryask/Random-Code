/*
* 
** Asked in amazon interview
** A rabbit starts from the first carrot
** eats all the consecutive carrots 
** with similiar category (if freq > 1)
** print the left carrots at the end
* T(n) : O(n)
* S(n) : O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class RemoveAllTheConsecutiveDuplicateGroupOfNumbersFromTheArray
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
	
	static String removeDups(String str)
	{
		Stack<Pair> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++)
		{			   
		   if(!stack.isEmpty() && stack.peek().ch == str.charAt(i))
			   stack.peek().freq++;				   
           else		   
		   {
			   /*
			   * before pushing the current element into stack
			   * check if stack is not empty and frequency of 
			   * the peek element is greater than 1
			   * remove it
			   */
			   if(!stack.isEmpty() && stack.peek().freq > 1)
				   stack.pop();
			   /*
			   * After removing the peek 
			   * check if stack is not empty,  the current peek
			   * could be same as the character to push 
			   * hence incrse the frequencey of the peek element
			   */
			   if(!stack.isEmpty() && stack.peek().ch == str.charAt(i))
				   stack.peek().freq++;
			   /*
			   * Now if stack is empty or peek is not same
			   * as the character to push, push the current 
			   * character with frequency as 1
			   */
			   else 
				   stack.push(new Pair(str.charAt(i), 1));
		   }
		}
		
		/*
		* Check the frequency of the top element now 
		* If greater than 1, pop it
		*/
		if(!stack.isEmpty() && stack.peek().freq > 1)
			stack.pop();
		
		StringBuilder sb = new StringBuilder();
		
		for(Pair p : stack)
			sb.append(p.ch);
		
		return sb.toString();
	}
	
	public static void main(String [] args)
	{
		//"geeksforgeeks";//*"qddxxxd";
		
       String str =  "fuhgfgjgfffzzz";//"yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
	   String rsltStr = removeDups(str);
	   out.println(rsltStr);
	}
}