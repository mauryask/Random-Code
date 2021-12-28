/*
* T(n) : O(n*logm)
* S(n) : O(n)
** https://www.geeksforgeeks.org/max-sum-of-m-non-overlapping-subarrays-of-size-k/
*/
import static java.lang.System.*;
import java.util.*;

public class MaxSumNNonOverlappingSubArrays
{
    static int maxSum(int[] A, int n, int m, int k)
    {
        Queue<Integer> q = new PriorityQueue<>();
        
        int i=0, j=0;
        int sum = 0;
        
        while(j<n)
        {
            sum += A[j];
            
            if(j-i+1 == k)
            {
                q.add(sum);
                if(q.size() > m)
                    q.remove();
                sum = 0;
                i=j+1;
            }
            
            j++;
        }
        
        q.add(sum);
        if(q.size() > m)
            q.remove();
        
        int maxSum = 0;
        
       while(!q.isEmpty())
        maxSum += q.remove();
       
       return maxSum;
    }
    
   public static void main(String [] args)
   {
       int A[] = {3, 2, 100, 1};
       int n = A.length;
       int m = 2;
       int k = 2;
       out.println(maxSum(A, n, m, k));
   }
}