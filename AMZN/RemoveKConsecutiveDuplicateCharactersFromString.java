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
	static void removeDups(String str, int k)
	{
		char chArr[] = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		Map<Character, Integer> map = new HashMap<>();
		
		stack.push(chArr[0]);
		map.put(chArr[0], 1);
		
		for(int i=1; i<chArr.length; i++)
		{
			    char ch = chArr[i];
			
				if(!stack.isEmpty()
					&& ch == stack.peek())
				{
					map.put(ch, map.get(ch)+1);
					
					if(map.get(ch) == k)
						stack.pop();					
				}
				else
				{
					map.put(ch, 1);
					stack.push(ch);
				}
		}
		
		out.println(stack);
	}
	
	public static void main(String [] args)
	{
       String str =  "qddxxxddpppxhxxtttxx";
	   int k = 2;
	   removeDups(str, k);
	}
}