/*
* Time complexity  : O(n)
* Space complexity : O(1)
*****************
https://www.geeksforgeeks.org/given-sorted-array-number-x-find-pair-array-whose-sum-closest-x/
*****************
See Brute force solution as well
*/

import static java.lang.System.*;
import java.util.*;

public class ClosetSum 
{
	static int[] closetSum(int A[], int n, int temp)
	{
		int start = 0;
		int end = n-1;
		int minDiff = Integer.MAX_VALUE;
		int sol[] = new int[2];
		
		while(start < end)
		{
			/*
			* Maintain minDiff variable
			* Minimum the value of the minDiff
			*(diff. between sum and temp)
			* More closer the sum will be to the temp
			*/
						
		   int sum = A[start] + A[end];
		   int diff = Math.abs(sum - temp);

			if(minDiff > diff)
			{
				minDiff = diff;
				sol[0] = A[start];
				sol[1] = A[end];
				
				/*
				*  if diff = 0, means (sum = temp) 
				*  this is going to the closest sum don't 
				*  need to continue our search further
				*/
				
				if(diff =  0)
					return sol;
			}				
			
			/* 
			* The purpose of following operation is
			* to move the pointer towards the pairs 
			* that can give sum closer to the 
			* the given value (target)
			*/
			
			if(sum > temp)
				end--;
			
			else if(sum < temp)
				start++;
		}
		
		return sol;
	}
		
	/*
	* Time complexity: O(n*n)
	* Space complexity: O(1)
	*/
	static int[] bruteForce(int A[], int n, int temp)
	{
	   int minDiff = Integer.MAX_VALUE;
	   int sol[] = new int[2];
	   
	   for(int i=0; i<n-1; i++)
	   {
		   for(int j= i+1; j<n; j++)
		   {
			   int sum = A[i] + A[j];
			   int diff = Math.abs(sum -temp);
			   
			   if(minDiff > diff)
			   {
				   minDiff = diff;
				   sol[0] = A[i];
				   sol[1] = A[j];
			   }
		   }
	   }
	   return sol;
	}
	
	public static void main(String [] args)
	{
		int A[] = {10, 22, 28, 29, 30, 40};
		int n = A.length;
		
		//int sol[] = closetSum(A, n, 54);
		int sol[] = bruteForce(A, n, 54);
		
		out.println("("+sol[0]+", "+sol[1]+")");
	}
}