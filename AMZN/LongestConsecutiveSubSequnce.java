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
	
	// Brute force solution 
	// T(n) : O(n*log n)
	// S(n) : O(n) 
	
	static int getLength(int[] A, int n)
	{
		Arrays.sort(A);
		int maxLen = 0;
		int count = 0;
		List<Integer> list = new ArrayList<>();
		list.add(A[0]);
		
		// Keep only unique elements in the list
		for(int i=1; i<n; i++)
		{
			if(A[i] != A[i-1])
				list.add(A[i]);
		}
		
		// find the max length	
	    for(int i=0; i<list.size(); i++)
		{
			if(i>0 && list.get(i) == list.get(i-1)+1)
				count++;
			else
				count = 1;
			
			maxLen = Math.max(maxLen, count);
		}
		
	    return maxLen;
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,9,8,7,9, 3, 10, 4, 20, 2};
		int n = A.length;
		/*getMaxLength(A, n);
		out.println(maxLength);*/
		
		out.println(getLength(A, n));
	}
}