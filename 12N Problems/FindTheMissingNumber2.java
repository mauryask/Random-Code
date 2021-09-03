/*
* T(n) : O(n)
* S(n) : O(1)
******
Problem Statement:
https://www.geeksforgeeks.org/find-the-missing-number/
**/

import static java.lang.System.*;

public class FindTheMissingNumber2
{

	static int findMissing(int A[], int n)
	{
		int arrSum = 0;
		int nSum = 0;
		int count = 1;
		
		for(int x : A)
		{
			arrSum += x;
			nSum += count;
			count++;
		}
		
		nSum += count;
		
		return nSum - arrSum;
	}
	
	/*
	* T(n) : O(n)
	* S(n) : O(n) Solution
	**/
	static int solution2(int A[], int n)
	{
		/*
		* Creating an array of required size
		* the indices of which will contain
		* the value from 1 to n
		***********************
		* Each element 'Ai' is an index 
		* in the array 'temp' 
		* 
		*/
		
		int temp[] = new int[n+2];
		
		for(int x : A)
			temp[x]++;
		
		for(int i=1; i<n+2; i++)
		{
			if(temp[i] != 1)
				return i;
		}
		
		return -1;
	}
	
	public static void main(String [] args)
	{
		int A[] ={1, 2, 4, 6, 3, 7, 8};
		int n = A.length;
		
		//out.println(findMissing(A, n));
		
		
		out.println(solution2(A, n));
	}
}