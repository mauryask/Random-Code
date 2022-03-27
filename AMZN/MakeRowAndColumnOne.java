/*
* https://www.geeksforgeeks.org/a-boolean-matrix-question/
*/
import static java.lang.System.*;
import java.util.*;

class Pair 
{
	int x;
	int y;
	
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class MakeRowAndColumnOne
{
	/*
	* T(n) : O(m*n)
	* S(n) : O(m*n)
	*/
	static void solve(int[][] grid, int m, int n)
	{
		Queue<Pair> q = new LinkedList<>();
		
		// collect the locations with value 1
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(grid[i][j] == 1)
					q.add(new Pair(i, j));
			}
		}
		
		Set<Integer>  rowSet = new HashSet<>();
		Set<Integer>  colSet = new HashSet<>();
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;									
						
			if(!rowSet.contains(x))
			{
				for(int i=0; i<n; i++)
				   grid[x][i] = 1;
			}
			
			if(!colSet.contains(y))
			{
				for(int i=0; i<m; i++)
				    grid[i][y] = 1;
			}
			
			rowSet.add(x);
			colSet.add(y);
		}
	}
	
	/*
	* T(n) : O(m*n)
	* S(n) : O(m+n)
	*/
	static void solve2(int[][] grid,int m,int n)
	{
	    boolean row[] = new boolean[m];
		boolean col[] = new boolean[n];
		
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(grid[i][j] == 1)
				{
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				grid[i][j] = (row[i]|| col[j]) ? 1 : 0;
			}
		}
		
	}
	
	static void printGrid(int[][] grid)
	{
		for(int[] arr : grid)
		{
			for(int x : arr)
				out.print(x+" ");
			out.println();
		}
	}
	
	/*
	* T(n) : O(m*n)
	* S(n) : O(1)
	** Best mehtod
	** It is same as previous, here first row and column 
	** will be treated as the row and col matrix as in solve2()
	*/
	
  static void solve3(int[][] grid, int m,int n)
  {
	  boolean rowFlag = false;
	  boolean colFlag = false;
	  
	  // record the status in first row and 
	  // first column
	  for(int i=0; i<m; i++)
	  {
		  for(int j=0; j<n; j++)
		  {
			  if(i==0 && grid[i][j] == 1)
				  rowFlag = true;
			  
			  if(j == 0 && grid[i][j] == 1)
				  colFlag = true;
			  
			  if(grid[i][j] == 1)
			  {
				  grid[i][0] =  1;
				  grid[0][j] = 1;
			  }
		  }		 
	  }	  
         // update rest of the part of the grid 	  
	  	  for(int i=1; i<m; i++)
		  {
			  for(int j=1; j<n; j++)
			  {
				 if(grid[i][0] == 1 || grid[0][j] == 1)
						grid[i][j] = 1;
			  }
		  }
		  
		  // update first row
		  if(rowFlag)
		  {
			  for(int i=0; i<m; i++)
				  grid[i][0] = 1;
		  }
		  // update first column
		  if(colFlag)
		  {
			  for(int j=0; j<n; j++)
				  grid[0][j] = 1;
		  }
  }
	
  public static void main(String [] args)
  {
	  int grid[][] = {{1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0}};	  
	  int m = grid.length;
	  int n = grid[0].length;
	  solve3(grid, m, n);
	  printGrid(grid);
  }
}