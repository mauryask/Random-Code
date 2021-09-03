/*
* Time Complexity  : O(n)
* Space complexity : O(1)
***************
* This algorithm works for 
* multiple missing multiple duplicates
* as well
*/

import static java.lang.System.*;

public class SwapSort
{
	static void findMissingAndDuplicate(int A[], int n)
	{
		int i=0;
		
		while(i<n)
		{
			if(A[i] != i+1)
			{
				int temp = A[i];
				int tempIndex = A[i]-1;
				
				/*
				* if A[tempIndex] already has A[i]
				* taht means A[i] is duplicate
				* Now can do nothing just go
				* to next element
				*/
				if(A[tempIndex] == A[i])
				{
					out.println("Missing: "+(i+1)+
					"\nDuplicate: "+A[i]+
					"\n========");
				}
				else
				{
					A[i] = A[tempIndex];
					A[tempIndex] = temp;
					// don't go to next element yet
					continue; 
				}				
			}
			
			i++;
		}
	}
	
	public static void main(String [] args)
	{
		int A[] = {2,4,3,1,3,7,8,7};
		int n = A.length;
		
		findMissingAndDuplicate(A, n);
	}
}