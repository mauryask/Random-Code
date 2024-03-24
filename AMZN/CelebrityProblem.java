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
	
	static int getCeleb(int[][] grid, int n)
	{
		int candidateId = -1;
		
		//Finding possible candidate to be celebrity
		//Check if the candidate does not know any one
		for(int i=0; i<n; i++)
		{
			boolean flag = true;
			
			for(int j=0; j<n; j++)
			{
				if(grid[i][j] == 1)
				{
					flag = false;
					break;
				}
			}
			
			//If does not know any one 
			//Possible candidate found
			if(flag)
			{
				candidateId = i;
				break;
			}
		}
		
		if(candidateId == -1)
			return -1;
		
		//Check if this candidate is known to every one
		for(int i=0; i<n; i++)
		{
			if(candidateId == i)
				continue;			
			if(grid[i][candidateId] != 1)
				return -1;
		}
		
		return candidateId;
	}
	
	/*
	* T(n) : O(n) 
	* S(n) : O(n)
	** best solution
	*/
	 static int findCeleb2(int[][] grid, int n)
	 {
		 Stack<Integer> stack = new Stack<>();
		 // push all the candidate Ids in the stack
		 for(int i=0; i<n; i++)
			 stack.push(i);
		 
		 while(stack.size() > 1)
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
			 if(i!=celebId && (grid[i][celebId] != 1 || grid[celbId][i] == 1))
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