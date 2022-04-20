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
		// this variable determines whether a person 
		// is possible candidate to be a celebrity or not
		boolean isPossibleCeleb = true;
		
		// find the possible candidate 
		// which does not know any one
		for(int i=0; i<n; i++)
		{
			// initially assume that every candidate is 
			// a possible celebrity
			isPossibleCeleb = true;
			
			for(int j=0; j<n; j++)
			{
				// if for the current candidate  
				// if any of the value is 1 
				// then it means it knows someone 
				// and can not be possible candidate 
				// to be a celebrirty
				if(i!=j && grid[i][j]== 1)
				{
					isPossibleCeleb = false;
					break;
				}
			}
			
			// if a possible candidate is found
			// set the celebrity Id and break
			if(isPossibleCeleb)
			{
				celebId = i;
				break;
			}
		}
		
		// if possible candidate is found 
        // check if this candidate is known to everyone		
		if(isPossibleCeleb)
		{
			for(int i=0; i<n; i++)
			{
				// if not known by any of the 
				// person in the meeting  except himself
				// he is out of the race to be a celebrity
				// return -1
				if(i!=celebId && grid[i][celebId] !=1)
					return -1;
			}
		}
		
		// else return celebId
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
	 
	 // T(n) = O(n)
	 // S(n) = O(1)
	 
	 static int findCeleb3(int grid[][] ,int n)
	 {
		  int celebId = -1;
		  
		  int i=0, j= n-1;
		  // find the possibel candidate		  
		  while(i<j)
		  {
			  if(grid[j][i] == 1)
				  j--;
			  else 
				  i++;
		  }
		  
		  celebId = i;
		  
		  // check if the possible
		  for(i=0; i<n; i++)
		  {
			  if(i != celebId && (grid[i][celebId] == 0 
			  || grid[celebId][i] == 1))
			   return -1;
		  }
		  
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
     int celebId = findCeleb3(grid, n);
     out.println( celebId == -1 ? "No celebrity" : celebId);	 
  }
}