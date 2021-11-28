import static java.lang.System.*;
import java.util.*;

public class MaxSumConfiguration
{
	static int maxSumConfig(int[] A,int n)
	{
	    int sum = 0;
        for(int x: A)
			sum += x;
		
	    int s = 0;
		for(int i=0; i<n; i++)
			s += i*A[i];
		
		int maxSum = s;
		// Si+1 = Si + sum - n * A[n-i]
		for(int i = 1; i<n; i++)
		{
			s += sum - n * A[n-i];
            maxSum = Math.max(maxSum, s);			
		}
		
		return maxSum;
	}
	
	public static void main(String [] args)
	{
		int A[] = {8,3,1,2};
		int n = A.length;
		out.println(maxSumConfig(A,n));
	}
}