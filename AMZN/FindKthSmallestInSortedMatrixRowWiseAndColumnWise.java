import static java.lang.System.*;
import java.util.*;

public class FindKthSmallestInSortedMatrixRowWiseAndColumnWise 
{
	// using minHeap
	static int findKthMin(int[][] A, int n, int k)
	{
		Queue<Integer> q = new PriorityQueue<>();
		
		for(int x[] : A)
		{
			for(int y: x)
				q.add(y);
		}                                                                                   
		
		int count  = 0;
		
		while(!q.isEmpty() && count < k-1)
		{
			q.remove();
			count++;
		}
		
		return count == k-1 && !q.isEmpty() ? q.remove() : -1;  
	}
	
	// by mering the arrays
	static void method2(int[][] A, int n , int k)
	{
		int temp[] = new int[n];
		int mergedArray[] = new int[n*n];
		
		for(int i=0; i<n; i++)
		{
			temp = merge(temp, A[i]);
		}
	}
	
	public static void main(String [] args)
	{
		int[][] A = {
        { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 25, 29, 37, 48 },
        { 32, 33, 39, 50 },
    };
		int n = A.length;
		int k = 7;
		out.println(findKthMin(A, n, k));
	}
}