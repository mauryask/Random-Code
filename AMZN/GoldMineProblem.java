/*
* https://www.geeksforgeeks.org/gold-mine-problem/
*/
import static java.lang.System.*;
import java.util.*;

public class GoldMineProblem
{

	/*
	* T(n) : Kind of cubic : (3^m*n) : not sure
	*/

	static int bruteForce(int[][] A, int m, int n)
	{
		int maxGold = 0;
		
		for(int i=0; i<m; i++)
		{
			maxGold = Math.max(maxGold, collectGold(A, i, 0,m,n));
		}
		
		return maxGold;
	}
		
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
		
		for(int j=n-1; j>=0; j--)
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
	
	//**********************
	
	//Bootom up O(m*n) Best approach
	static int getValue(int i, int j, int m, int n, int[][] dp)
	{
		if(i<m && i>=0 && j<n && j>=0)
			return dp[i][j];
		return Integer.MIN_VALUE;
	}
	
	static int getMaxGold(int[][] grid)
	{
		int m = grid.length;
		int n = grid[0].length;
		
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<m; i++)
		   dp[i][n-1] = grid[i][n-1];
	   
	    for(int j=n-2; j>=0; j--)
		{
			for(int i=m-1; i>=0; i--)
			{
				int right = getValue(i, j+1, m, n, dp);
				int topRight = getValue(i-1, j+1, m, n, dp);
				int bottomRight = getValue(i+1, j+1, m, n, dp);
				dp[i][j] = Math.max(right, Math.max(topRight, bottomRight)) + grid[i][j];
			}
		}
		
	    int maxGold = 0;
		
		for(int i=0; i<m; i++)
			maxGold = Math.max(maxGold, dp[i][0]);
		return maxGold;
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