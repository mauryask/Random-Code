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
   
   static void asteroidCollision(int A[], int n)
   {
	   // It stores asteroids to the left
	   Stack<Integer> stack = new Stack<>();
	   
	   stack.push(A[0]);
	   
	   for(int i=1; i<n; i++)
	   {
		   /*
		   * The asteroid wil collide if and only 
		   * if stack(top) > 0 and A[i] < 0
		   * i.e. they are moving in opposite direction
		   */
		   if(!stack.isEmpty() && 
		   stack.peek() > 0 && A[i] < 0)
		   {
			   int x = A[i];
			   boolean isEqual = false;
			   
			   while(!stack.isEmpty() && 
			   stack.peek() > 0 && x < 0)
			   {
				   /*
				   * Even after removing top of stack
				   * there might be chances of collision
				   * so update x until the condition holds
				   ****
				   * top of stack reprseents the current asteroid
				   */
				   int y = stack.pop();
				  
				   if((-x) == y)
				   {
					   isEqual =  true;
					   break;
				   }
				   /*
				   * The one which is smaller will explode
				   * x is the asteroid that will persist
				   */
				   else if((-x) < y)
					   x = y;
			   }
			   
			   /*
			   * if both asteroids are of eqaul size
			   * then both will explode no need to keep it
			   * in the stack
			   */
			   if(!isEqual)
			      stack.push(x);
		   }
		   /*
		   * If collision condition is not satishfied
		   * push the element in the stack
		   */
		   else 
		     stack.push(A[i]);
	   }
	   
	   out.print(stack);
   }

	public static void main(String [] srga)
	{
		int A[] = {10,2,-5};
		int n = A.length;
		//asteroidCollision(A, n);
		asteroidState(A, n);
	}	
}