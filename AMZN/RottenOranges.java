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
	
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(A[i][j] == 2)
					q.add(new Orange(0, i, j));
			}
		}

		int time = 0; // total time
		
		while(!q.isEmpty())
		{
			Orange g = q.remove();
			int t = g.t;
			int x = g.x;
			int y = g.y;
			
			time = t;
			
			int dx[] = {-1,0,1,0};
			int dy[] = {0,-1,0,1};
			
			for(int i=0; i<4; i++)
			{
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if(newX<m && newY<n && newX>=0 && newY>=0 && A[newX][newY]==1)
				{
					A[newX][newY] = 2;
					q.add(new Orange(t+1, newX, newY));
				}
			}				

		}
		
		
		
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
			
			int dx[] = {-1,0,1,0};
			int dy[] = {0,-1,0,1};
			
			for(int i=0; i<4; i++)
			{
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if(newX<m && newY<n && newX>=0 && newY>=0 && A[newX][newY]==1)
				{
					A[newX][newY] = 2;
					q.add(new Orange(t+1, newX, newY));
				}
			}				
		}
	
	public static void main(String [] args)
	{
		// the baseket containing oranges
		int A[][] = { {2, 1, 0, 2, 1},
                     {0, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
		
		// find time frame
		timeFrame(A, 3, 5);
	}
}