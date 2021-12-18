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
       
       for(int x: A)
           map.put(x, map.getOrDefault(x, 0)+1);
       
       Queue<Integer> q = new PriorityQueue<>((a, b)->{
         return map.get(b) - map.get(a);
       });

       for(int x: A)
       {
           q.add(x);           
           if(q.size() > k)
            q.remove();
           printHeap(q);
       }
   }
   
   static void printHeap(Queue<Integer> q)
   {
       for(int x : q)
           out.print(x+" ");
   }
   
  public static void main(String [] args)
  {
	  int[] A = {5, 2, 1, 3, 4};
      int n = A.length;
      int k = 4;
      solve(A, n, k);
  }
}