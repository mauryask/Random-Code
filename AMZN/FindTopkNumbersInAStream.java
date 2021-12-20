/*
* T(n) : O(n*log k)
* S(n) : O(n)
** https://www.geeksforgeeks.org/find-top-k-or-most-frequent-numbers-in-a-stream/
*/

import static java.lang.System.*;
import java.util.*;

public class FindTopkNumbersInAStream
{
   static void solve(int A[] , int n, int k)
   {
       Map<Integer, Integer> map = new HashMap<>();
       
       Queue<Integer> q = new PriorityQueue<>((a, b)->{
         return map.get(a) - map.get(b);
       });

       for(int x: A)
       { 
           map.put(x, map.getOrDefault(x, 0)+1);     
           if(q.contains(x))
              q.remove(x);
          
           q.add(x);       
           
           if(q.size() > k)
            q.remove();
        
           printHeap(q);
       }
   }
   
   static void printHeap(Queue<Integer> q)
   {
       Stack<Integer> stack = new Stack<>();
       for(int x: q)
           stack.push(x);
       while(!stack.isEmpty())
           out.print(stack.pop()+" ");
       out.println();
   }
   
  public static void main(String [] args)
  {
	  int[] A = {5, 2, 1, 3, 2};
      int n = A.length;
      int k = 4;
      solve(A, n, k);
  }
}