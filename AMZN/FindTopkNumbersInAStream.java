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
       /*
       * Min heap based on frequencey of the elements
       */
       Queue<Integer> q = new PriorityQueue<>((a, b)->{
         return map.get(a) - map.get(b);
       });

       for(int x: A)
       { 
           map.put(x, map.getOrDefault(x, 0)+1);     
           
           /*
           * check if the heap already has 
           * the element, remove it to prevent duplicasy
           * as priority queue allows 
           * duplicate elements
           **/
           
           if(q.contains(x))
              q.remove(x);
          
           q.add(x);       
           
           /*
           * Since we need only tp k elements 
           * remove uneceesary elements keep only 
           * k elements
           **/
           
           if(q.size() > k)
            q.remove();
        
           printHeap(q);
       }
   }
   
   /* 
   * print elements from down to top 
   * as we have taken min heap 
   * bottom of the heap is going to 
   * have max frequncy elements
   */
   
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