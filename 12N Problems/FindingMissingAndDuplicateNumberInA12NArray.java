/*
* Time complexity  : O(n)
* Space complexity : O(1)
*************************
Here Array need not to be sorted
*************************
* Problem Statement
* https://www.interviewbit.com/problems/repeat-and-missing-number-array/
*/

import static java.lang.System.*;
import java.util.*;


public class FindingMissingAndDuplicateNumberInA12NArray
{
	static void findMissingAndDuplicate(int A[], int n)
	{
		int nSum = 0;
		int arrSum = 0;
		int nSqrSum = 0;
		int arrSqrSum = 0;
		
	    int count = 1;
		
		for(int x : A)
		{
			arrSum += x;
			arrSqrSum += x*x;
			nSum += count;
			nSqrSum += count * count;
			count++;			
		}
		
		// this calculation will give (duplicate - mising)
		int a = arrSum - nSum;
		// this calculation will give (duplicate^2 - mising^2)
		int b = arrSqrSum - nSqrSum;
		// this calculation will give (duplicate + mising)
		int c = b/a;
		
		out.println("Duplicate: "+ (c+a)/2);
		out.println("Missing: "+ (c-a)/2);
	}
	
	static void solution2(int A[], int n)
	{
		/*
		* Create array of size n+1
		* indices of this will contain elements 
		* from 1 to n 
		*********************
		* Each element 'Ai' is index of array 'temp'
		*/
		int temp[] = new int[n+1];
		
		for(int x : A)
			temp[x]++;
		
		for(int i=1; i<=n; i++)
		{
			/*
			* for duplicate element 
			* the value = 0
			******
			* for duplicate elements 
			* the value > 1
			*/
			if(temp[i] > 1)
				out.println("Duplicate: "+i);
			else if(temp[i] == 0)
				out.println("Missing: "+i);
		}
	}
	
	
	public static void main(String [] args)
	{
		/*
		- Here 2 is missing and 
		- on place of 4 is kept (duplicated)
		*/
		int A[] = {1,4,3,4,5,6,7,8,9,10,11};
		int n = A.length;
		
		//findMissingAndDuplicate(A, n);
		solution2(A, n);
	}
}