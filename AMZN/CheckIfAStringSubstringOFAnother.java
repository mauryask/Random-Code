/*
* This is not the actual solution to this problem 
* It should be solved using KMP algorithm
* Time complexity is same for both : O(m*n)
* but space complexity is better in KMP : O(1)
*/
import static java.lang.System.*;
import java.util.*;

public class CheckIfAStringSubstringOFAnother 
{
	static boolean isSubstring(String s1, String s2, int m, int n)
	{
		int dp[][] = new int[m+1][n+1];
		int max = 0;
		int x=0, y=0;
		
		for(int i=1; i<m+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1] + 1;
					if(max< dp[i][j])
					{
						max = dp[i][j];
						x = i;
						y = j;
					}
				}
				else 
					dp[i][j] = 0;
			}
		}
		
		if(dp[x][y] == n)
			return true;
		return false;
	}
	
	public static void main(String [] args)
	{
		String s1 =  "geeksforgeeks";
		String s2 = "practice";
		int m = s1.length();
		int n = s2.length();
		
		out.println(isSubstring(s1, s2, m, n));
	}
}