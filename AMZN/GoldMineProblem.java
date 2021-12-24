/*
* https://www.geeksforgeeks.org/gold-mine-problem/
*/
import static java.lang.System.*;
import java.util.*;

public class GoldMineProblem
{
	static int bruteForce(int[][] A, int m, int n)
	{
		int maxGold = 0;
		
		for(int i=0; i<m; i++)
		{
			maxGold = Math.max(maxGold, collectGold(A, i, 0,m,n));
		}
		
		return maxGold;
	}
	
	/*
	* T(n) : Kind of cubic : (m*m*n) > mot sure
	* S(n) : O(1) > if recursion stack is not considered
	* since there are lot of overlapping sub problems
	* we can go with dp;
	*/
	
	static int collectGold(int[][] A, int i, int j, int m, int n)
	{
	   if(!isSafe(i,j,m,n))
			return 0;
		
	   int right =  collectGold(A, i,j+1,m,n) ;
       int topDiag = collectGold(A,i-1,j+1,m,n);
       int bottomDiag = collectGold(A, i+1,j+1,m,n);

       return A[i][j] + Math.max(right, Math.max(topDiag, bottomDiag));	   
	}
	
	/*
	* BEst DP based solution
	* T(n) : O(m*n)
	* S(n) : O(1)
	*/
	static int maxGold(int[][] A, int m, int n)
	{
	    int max = 0;
		
		for(int j=n-2; j>=0; j--)
		{
			for(int i=m-1; i>=0; i--)
			{
				int right = isSafe(i, j+1,m,n) ? A[i][j+1] : 0;
				int topDiag = isSafe(i-1,j+1, m,n)? A[i-1][j+1] : 0;
				int bottomDiag = isSafe(i+1, j+1, m, n) ? A[i+1][j+1] : 0;
				
				A[i][j] = A[i][j] + Math.max(right, Math.max(topDiag, bottomDiag));
				
				if(j==0)
				  max = Math.max(max, A[i][0]);
			}
		}
		
		return max;
	}
	
	static boolean isSafe(int i, int j, int m, int n)
	{
		return i>=0 && j>=0 && i<m && j<n; 
	}
	
	public static void main(String [] args)
	{
		int A[][] = { {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}};
		int m = A.length;
		int n = A[0].length;
		
		out.println(bruteForce(A, m, n));
	}
}