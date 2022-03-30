/*
** Here we are always going to have 
** exactly only one celebrity or not at all
*/
import static java.lang.System.*;
import java.util.*;

public class CelebrityProblem
{
	/*
	* T(n) : O(n*n)
	* S(n) : O(1)
	*/
	
	static int findCeleb(int[][] grid,int n)
	{
		// Id of the possible candidate
		// of being a celebrity
		int celebId = -1;
		// this variable true means, the candidate 
		// knows someone and no more in the race of
		// being a celebrity and vice-versa
		boolean knowsSomeone = true;
		
		// find the possible candidate 
		// which does not know any one
		for(int i=0; i<n; i++)
		{
			knowsSomeone = false;
			
			for(int j=0; j<n; j++)
			{
				if(grid[i][j] == 1)
				{
					knowsSomeone = true;
					break;
				}
			}
			
			if(!knowsSomeone)
			{
				celebId = i;
				break;
			}
		}
		// check if that candidate 
		// known by everyone or not
		if(!knowsSomeone)
		{
			for(int i=0; i<n; i++)
			{
				// if not known by any of the 
				// person in the meeting  except himself
				// return -1
				if(i!=celebId && grid[i][celebId] !=1)
					return -1;
			}
		}
		
		// return celebId
		return celebId;
	}
	
	/*
	* T(n) : O(n) 
	* S(n) : O(n)
	** best solution
	*/
	 static int findCeleb2(int[][] grid, int n)
	 {
		 Stack<Integer> stack = new Stack<>();
		 // push all the candate Ids in the stack
		 for(int i=0; i<n; i++)
			 stack.push(i);
		 
		 while(stack.size() >= 2)
		 {
			 int a = stack.pop();
			 int b = stack.pop();
			 /*
			 * If a knows b a is no more in the race
             * of being a celebrity (as celebrity does not know
			 anybody)
             * dont push back a
			 */
			 if(grid[a][b] == 1)
				 stack.push(b);
			 else
				 stack.push(a);
		 }
		 
		 // we got the possible candidate 
		 // of being a celebrity 
		 int celebId = stack.pop();
		 
		 // check if this candidate is known 
		 // by everybody
		 for(int i=0; i<n; i++)
		 {
			 // if now known by anyof theperson 
			 // return -1
			 if(i!=celebId && grid[i][celebId] !=1)
				 return -1;
		 }
		 
		 // return celebrity id
		 return celebId;		 
	 }
	
  public static void main(String [] args)
  {
	  int grid[][] =   {{0,0,1,0},
		                {0,0,1,0},
			            {0,0,0,0},
				        {0,0,1,0}};
					    /*{{0, 0, 1, 0},
					    {0, 0, 1, 0},
					    {0, 1, 0, 0},
					    {0, 0, 1, 0}};*/
	 int n = grid.length;
     int celebId = findCeleb2(grid, n);
     out.println( celebId == -1 ? "No celebrity" : celebId);	 
  }
}