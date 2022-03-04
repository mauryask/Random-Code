import static java.lang.System.*;
import java.util.*;

public class LongestConsecutiveSubSequnce 
{
	/*
	* T(n) : O(n)
	* S(n) : O(n)
	*/
	static int maxLength = 0;
	static void getMaxLength(int[] A, int n)
	{
		Set<Integer> set = new HashSet<>();
		/*
		* Each every element is a consecutive
		* subsequence of size 1 so put true in the set
 		*/
		for(int x : A)
			set.add(x);
				
		/*
		* For each element that is starting of its 
		* subsequence find max consecutive length
		*/
		
		for(int x : A)
		{			
			if(!set.contains(x-1))
			{
				int temp = x;			
				int max = 0;
				
				while(set.contains(temp))
				{
					max++;
					temp++;	
				}
				
				maxLength = Math.max(max, maxLength);
			}
		}
	}
	
	public static void main(String [] args)
	{
		int A[] = {1, 9, 3, 10, 4, 20, 2};
		int n = A.length;
		getMaxLength(A, n);
		out.println(maxLength);
	}
}