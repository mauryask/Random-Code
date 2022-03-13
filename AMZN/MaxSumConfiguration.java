import static java.lang.System.*;
import java.util.*;

/*
* Here we are considering clock wise 
*  rotation
***
* Even on anticlock wise rotation we are going to
* get the same configurations
*/
public class MaxSumConfiguration
{
	static int maxSumConfig(int[] A,int n)
	{
	    int arrSum = 0;
		int configSum = 0;
		int maxConfigSum = 0;
		
		for(int i=0; i<n; i++)
		{
			arrSum += A[i];
			configSum += i*A[i];
		}
		
		maxConfigSum = configSum;
		// Ci = Ci-1 + sum - n * A[n-i]
		for(int i = 1; i<n; i++)
		{
			configSum = configSum + arrSum - n * A[n-i];
            maxConfigSum = Math.max(maxConfigSum, configSum);			
		}
		
		return maxConfigSum;
	}
	
	public static void main(String [] args)
	{
		int A[] = {8,3,1,2};
		int n = A.length;
		out.println(maxSumConfig(A,n));
	}
}