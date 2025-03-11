/*
* T(n) : O(n*n)
* S(n) : O(n)
** Satisfies all the test cases
** of the Leet Code
*/

import static java.lang.System.*;
import java.util.*;

public class LongestIncreasingSubsequence 
{
	static void LISS(int[] A, int n)
	{
		// length
		int len[] = new int[n];
		//sequence index
		int seq[] = new int[n];
		
		Arrays.fill(len, 1);
		Arrays.fill(seq, -1);
		int maxIndex = 0;
		// maxLen is always will be one
		int maxLen = 1;
		
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(A[j] < A[i] && len[j]+1 >= len[i])
				{				
					   len[i] = len[j] + 1;
				       seq[i] = j;					   
				}
			}
			
			if(maxLen < len[i])
			{
				maxLen = len[i];
				maxIndex = i;
			}
		}
				
		// printing max increasing subsequence length
		out.println(maxLen);
		for(int x : seq)
			out.print(x+" ");
		out.println();
		out.println(maxIndex+"\n");
		// printing subsequence 
		printSubsequence(A, maxIndex, seq);
	}
	
	
	static void printSubsequence(int[] A, int maxIndex, 
	int [] seq)
	{
		int j = maxIndex;
		Stack<Integer> stack = new Stack<>();
		
		while(seq[j] != -1)
		{
			stack.push(A[j]);
			j = seq[j];
		}
		
		stack.push(A[j]);
		
		while(!stack.isEmpty())
		 out.print(stack.pop()+" ");
	}
	
	public static void main(String [] args)
	{
		int A[] = {10, 22, 9, 33, 21, 50, 41, 60};//{38,4,12,2,10,6,9,13,3,11,7,15};
		int n = A.length;
		LISS(A, n);
	}
}