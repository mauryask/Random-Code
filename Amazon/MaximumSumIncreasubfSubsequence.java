/*
* T(n) : O(nxn)
* S(n) : O(n)
* https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
*/
import static java.lang.System.*;
import java.util.*;

public class MaximumSumIncreasubfSubsequence 
{
	static int maxSum(int[] A, int n)
	{
		int sumArr[] =  new int[n];
		int maxSum  = 0;
		
		for(int i=0; i<n; i++)
			sumArr[i] = A[i];
		
		for(int i=1; i<n; i++)
		{
			for(int j=0;j<i; j++)
			{
				if(A[j] < A[i])
				{
					sumArr[i] = Math.max(sumArr[i],sumArr[j] + A[i]);
					maxSum = Math.max(maxSum, sumArr[i]);
				}
			}
		}
		
		return maxSum;
	}
	
	public static void main(String args[])
	{
		int A[] = {1, 101, 2, 3, 100, 4, 5};
		int n = A.length;
		out.println(maxSum(A, n));
	}
}