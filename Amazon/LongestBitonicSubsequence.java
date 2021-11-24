/*
** It is related to the LIS
* T(n) : O(n*n)
* S(n) : O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class LongestBitonicSubsequence
{
	// it is nothing but longest 
	// increasing from right
	static int[] lds(int A[], int n)
	{
		int ldsLen[] = new int[n];
		Arrays.fill(ldsLen, 1);
		
		for(int i=n-2; i>=0; i--)
		{
			for(int j=n-1; j>i; j--)
			{
				if(A[i] > A[j])
				{
					if(ldsLen[i] <= ldsLen[j]+1)
						ldsLen[i] = ldsLen[j] + 1;
				}
			}
		}
		
		return ldsLen;
	}
	
	// longest increasing from left
	static int[] lis(int[] A, int n)
	{
		int lisLen[] = new int[n];
		Arrays.fill(lisLen, 1);
			
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(A[i] > A[j])
				{
					if(lisLen[j]+1 >= lisLen[i])
				       lisLen[i] = lisLen[j] + 1;			   
				}
			}
		}
		
		return lisLen;
	}
	
	public static void main(String [] args)
	{
		int A[] = {80, 60, 30, 40, 20, 10};
		int n = A.length;
		
		int []ldsLen = lds(A, n);
		int []lisLen = lis(A, n);
				
	    int lbsLen = 1;

        for(int i=0; i<n; i++)
          lbsLen = Math.max(lbsLen, ldsLen[i]+lisLen[i]-1);		
	  
        out.println(lbsLen);	  
	}
}