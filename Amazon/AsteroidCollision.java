import static java.lang.System.*;
import java.util.*;

public class AsteroidCollision
{		 
  // Solution-1
   static void asteroidState(int[] A, int n)
   {
	   List<Integer> list = new ArrayList<>();
	   
	   for(int x : A)
		   list.add(x);
	   
	   int p1 = list.size()-1;
	   int p2 = p1-1;
	   
	   while(p2 >= 0)
	   {
		   /*
		   * Check if collision condition is met
		   */
		   if(list.get(p2) > 0 && list.get(p1) < 0)
		   {
			   /*
			   * If both asteroids are equal
			   * both wil explode
			   */
			   if(list.get(p2) == Math.abs(list.get(p1)))
			   {
				   list.remove(p1);
				   list.remove(p2);
			   }
			   /*
			   * One with smaller size will explode
			   */
			   else if(list.get(p2) > Math.abs(list.get(p1)))
				    list.remove(p1);
			   else
				   list.remove(p2);
			   /*
			   * Update pointers point to last to elements only
			   */
			   p1 = list.size()-1;
		       p2 = p1-1;
		   }
		   else
		   {
			   /*
			   * Update pointers if collision condition
			   * is not met
			   */
			   p1--;
			   p2--;
		   }
	   }
	   
	  out.println(list);
   }
   
   /*
   * Efficient Solution
   * T(n) : O(n)
   * S(n) : O(n)
   */
   
    static int[] asteroidCollision(int[] A) {
	   Stack<Integer> stack = new Stack<>();

	   for(int i=0; i<A.length; i++)
	   {
		   // This is the only case of collision
		   if(!stack.isEmpty() && stack.peek() > 0 && A[i] < 0)
		   {
			   // Get absolute value of the weight of asteroid	
               int activeAst = A[i] * -1;
			   // This variable tracks if the asteroid is still active
               boolean isActive = true;
               
			   // Run this loop until an asterloid encountered moving in the same direction i.e. -ve
               while(!stack.isEmpty() && stack.peek() > 0)
			   {
				  // 3 case
                  if(activeAst < stack.peek())
                  {
                      isActive = false;
                      break;
                  }
                  else if(activeAst > stack.peek())
                     stack.pop();
                  else if(activeAst == stack.peek()){
                    isActive = false;
                    stack.pop();
                    break;
                  }     
			   }
               // If asteroid still active push it in the stack
               if(isActive) stack.push(A[i]);
		   }
		   else 
		     stack.push(A[i]);
	   }
        
        // Convert the stack to an array.
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }

	public static void main(String [] srga)
	{
		int A[] = {-1,-2,1,3,1,2,-3,3};
		int n = A.length;
		//asteroidCollision(A, n);
		asteroidState(A, n);
	}	
}