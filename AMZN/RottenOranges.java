/*
* T(n) : O(m*n)
* S(n) : O(m*n)
* The idea is to apply BFS
***
* https://leetcode.com/problems/rotting-oranges/
*/

import static java.lang.System.*;
import java.util.*;

public class RottenOranges
{
	// information regarding each rotten orange
	static class Orange
	{
		int t;
		int x;
		int y;
		
		Orange(int t, int x, int y)
		{
			this.t = t;
			this.x = x;
			this.y = y;
		}
	}
		
	static void timeFrame(int[][] A, int m, int n)
	{
		Queue<Orange> q = new ArrayDeque<>();
		
		// store the info regarding each 
		// rotten orange in the begining		
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(A[i][j] == 2)
					q.add(new Orange(0, i, j));
			}
		}
		
		// total time frame to rot all the oranges
		int time = 0;
		
		while(!q.isEmpty())
		{
			Orange g  = q.poll();
			/*
			* The time frame of last rotten orange
			* is going to be the total time frame 
			*/
			time = g.t;
			
			/*
			 * Rot the fresh oranges in the 
			 * adjacent cells if it is one
			 */
			 
			rotAdjacentOranges(A, g, q, m, n);
		}
		
		/*
		* After all the oranges rotten
		* Check if there exist any orange 
		* fresh (which was not in direct contact with
		* a rotten orange)
		*/
		
		for(int[] x : A)
		{
			for(int y : x)
			{
				if(y == 1)
				{
					out.println(-1);
					return;
				}
			}
		}
		
		out.println(time);
	}
	
	
	static void rotAdjacentOranges(int A[][], Orange g, 
		Queue<Orange> q, int m, int n)
		{
			int t = g.t;
			int x = g.x;
			int y = g.y;
			
			// rot up
			if(x-1 >= 0 && A[x-1][y] == 1)
			{
				A[x-1][y] = 2;
				q.add(new Orange(t+1, x-1, y));
			}
			
			// rot left
			if(y-1 >= 0 && A[x][y-1] == 1)
			{
				A[x][y-1] = 2;
				q.add(new Orange(t+1, x, y-1));
			}
			
			// rot down
		    if(x+1 < m && A[x+1][y] == 1)
			{
				A[x+1][y] = 2;
				q.add(new Orange(t+1, x+1, y));
			}
			
			// rot right
			if(y+1 < n && A[x][y+1] == 1)
			{
				A[x][y+1] = 2;
				q.add(new Orange(t+1, x, y+1));
			}	
		}
	
	public static void main(String [] args)
	{
		// the baseket containing oranges
		int A[][] =   {{2,1,1},{0,1,1},{1,0,1}};
		
		// find time frame
		timeFrame(A, 3, 3);
	}
}