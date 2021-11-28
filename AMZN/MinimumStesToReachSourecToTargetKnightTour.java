/*
* T(n) : O(n*n) : in worst case all the cells will be visited
* S(n) : O(n*n)
** https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
*/
import static java.lang.System.*;
import java.util.*;

class KnightMove 
{
	int x;
	int y;
	int step;
	
	KnightMove(int x, int y, int step)
	{
		this.x = x;
		this.y = y;
		this.step = step;
	}
}

public class MinimumStesToReachSourecToTargetKnightTour
{	
	static int dx[] = {-1,1,2,2,-2,-2,1,-1};
	static int dy[] = {2,2,1,-1,1,-1,-2,-2};
	
	static void minSteps(int n, int srcX, int srcY, int trgX, int targY)
	{
		Queue<KnightMove> q = new ArrayDeque<>();
		q.add(new KnightMove(srcX,srcY,0));
		int minStep = Integer.MAX_VALUE;
		boolean visited[][] = new boolean[n][n];
		visited[srcX][srcY] = true;
		
		while(!q.isEmpty())
		{
			KnightMove knight = q.poll();
			int x = knight.x;
			int y = knight.y;
			int step = knight.step;
			
			if(x==trgX && y==targY)
				minStep = Math.min(step, minStep);
			
			for(int i=0; i<8; i++)
			{
				int newX = x+dx[i];
				int newY = y+dy[i];
				
				if(newX<n && newX>=0 && newY<n && newY>=0 && !visited[newX][newY])
				{
					 q.add(new KnightMove(newX,newY,step+1));
					 visited[newX][newY] = true;
				}
			}
		}
		
		out.println(minStep);
	}
	
	public static void main(String [] args)
	{
		int n = 8;
		minSteps(n,3,4,0,0);
	}
}