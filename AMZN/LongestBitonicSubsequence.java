/*
** It is related to the LIS
* T(n) : O(n*n)
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class LongestBitonicSubsequence
{
	int lisSeq[];
	int ldsSeq[];
	int n;
	static int peakIndex = 0;
	
	LongestBitonicSubsequence(int n)
	{
		this.n = n;
		lisSeq =  new int[n];
		ldsSeq =  new int[n];
		Arrays.fill(lisSeq, -1);
		Arrays.fill(ldsSeq, -1);
	}
	// it is nothing but longest 
	// increasing from right
	int[] lds(int A[], int n)
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
					{
						ldsLen[i] = ldsLen[j] + 1;
						ldsSeq[i] = j;
					}
				}
			}
		}
		
		return ldsLen;
	}
	
	// longest increasing from left
	int[] lis(int[] A, int n)
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
					{
						lisLen[i] = lisLen[j] + 1;
						lisSeq[i] = j;
					}			   
				}
			}
		}
		
		return lisLen;
	}
	
	void printSequence(int[] A)
	{
		//lis 
		int temp =  peakIndex;
		List<Integer> list = new LinkedList<>();
		
		while(lisSeq[temp] != -1)
		{
			list.add(0,A[temp]);
			temp = lisSeq[temp];
		}
		
        list.add(0,A[temp]);
        		
		// lds
		
		temp = ldsSeq[peakIndex];
		
		while(ldsSeq[temp] != -1)
		{
		   list.add(A[temp]);
           temp = ldsSeq[temp];		   
		}
		
		list.add(A[temp]);
		out.println(list);
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,11,2,10,4,5,2,1};
		int n = A.length;
		LongestBitonicSubsequence lbs = new LongestBitonicSubsequence(n);
		int []ldsLen = lbs.lds(A, n);
		int []lisLen = lbs.lis(A, n);
				
	    int lbsLen = 1;

        for(int i=0; i<n; i++)
		{
			int temp = lisLen[i] + ldsLen[i] - 1;
			
			if(lbsLen < temp)
			{
				lbsLen = temp;
				peakIndex = i;
			}
		}	
	  
        out.println("LBS length: "+lbsLen);	
        lbs.printSequence(A);		
	}
}