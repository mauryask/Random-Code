/*
* T(n) : exponantial
* S(n) : O(heigh of recursion tree)
*/

import static java.lang.System.*;
import java.util.*;

public class PartitionToKEqualSumSubsets 
{
	static boolean isPossible(int A[], int n, int k)
	{
		int sum = 0;
		
		for(int x : A)
			sum += x;
		
		if(sum % k != 0 || n < k)
		   return false;
	   
	    
		int targetSum =  sum / k;
		boolean[] visited = new boolean[n];
		
        return 	isPossibleUtil(A, visited, 0, 
		k, 0, targetSum, n);
	}
	
	static boolean isPossibleUtil(int[] A, boolean[] visited,
	int start,int k, int currentSum, int targetSum, int n)
	{
		if(k==0)
			return true;
		if(currentSum > targetSum)
			return false;
		if(currentSum == targetSum)
		  return isPossibleUtil(A, visited, 0, k-1, 
	      0, targetSum, n);
	  
	    for(int i=0; i<n; i++)
		{
			if(visited[i])
				continue;
			visited[i] = true;
			
			if(isPossibleUtil(A, visited, i+1, k, 
			currentSum + A[i], targetSum, n))
			  return true;
			  
			visited[i] = false;  
		}
		
		return false;
	}
	
	public static void main(String [] args)
	{
	    int A[] =  {4,3,2,3,5,2,1};
		int n = A.length;
		int k = 4;
		out.println(isPossible(A, n, k));
	}
}