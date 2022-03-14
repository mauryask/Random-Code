import static java.lang.System.*;
import java.util.*;

public class RearrangeArrayInAlternativeMaxAndMin 
{
	/*
	* T(n) : O(n) 
	* S(n) : O(n)
	*/
	static void reArrange(int[] A, int n)
	{
		int sol[] = new int[n];
		int left = 0;
		int right = n-1;
		int k  =0;
		
		while(left < right)
		{
			sol[k++] = A[right];
			sol[k++] = A[left];
			left++;
			right--;
		}
		
		if(left == right)
			sol[k] = A[left];
		
		for(int x : sol)
			out.print(x+" ");
	}
	
	/*
	* T(n) : O(n*n)
	* S(n) : O(1)
	*/	
	static void sol2(int[] A, int n)
	{
		int i = 0;
		
		while(i<n)
		{
			int temp  = A[n-1];
			
			for(int j=n-1; j>i; j--)
				A[j] = A[j-1];
			
			A[i] = temp;
			i += 2;
		}
		
		for(int x : A)
			out.print(x+" ");
	}
	
	public static void main(String [] args)
	{
		int A[]  = {1,2,3,4,5,6,7,8};
		int n = A.length;
		
		//reArrange(A, n);
		sol2(A, n);
	}
}