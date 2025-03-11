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
	static void getKthMin(int[][] grid, int k)
	{
		List<Integer> result = new ArrayList<>();
		
		for(int i=0; i<grid.length; i++)
		{
			List<Integer> list = new ArrayList<>();
			int[] A = grid[i];
			
			int j = 0;
			int l = 0;
			int n1 = result.size();
			int n2 = A.length;
			
			while(j<n1 && l<n2)
			{
				if(result.get(j) < A[l])
					list.add(result.get(j++));
				else
					list.add(A[l++]);
			}
			
			while(j<n1)
				list.add(result.get(j++));
			while(l<n2)
				list.add(A[l++]);
			
			result = list;
		}
		
		out.println(result.get(k-1));
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