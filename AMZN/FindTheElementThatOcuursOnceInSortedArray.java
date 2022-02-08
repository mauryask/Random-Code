/*
* https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/
*/
import static java.lang.System.*;
import java.util.*;

public class FindTheElementThatOcuursOnceInSortedArray
{	
    /*
	* T(n) = O(n)
	* S(n) = O(1)
	*/
    static int findEle(int A[], int n)
	{
	   for(int i=0; i<n; i+=2)
	   {		   
		   if(i == n-1)
			   return A[i];
		   if(A[i] != A[i+1])
			   return A[i];
	   }

		return -1;	   
	}
	
	/*
	* Since xor of two similiar elements gives 0
	* at the end we will get the element
	***
	* T(n) = O(n)
	* S(n) = O(1)
	*/
	
	static int findEle2(int A[], int n)
	{
		int xor = 0;
		
		for(int i=0; i<n; i++)
			xor ^= A[i];
		
		return xor;
	}
	
	
	/* Very Important
	**********
	* Best approach binary search
	* T(n) : O(log n)
	* S(n) : (1)
	************
	* Since first occurance at even index
	* second occurance at odd index
	*************
	* If the mid = even : check mid+1 if same it 
	* then it means that the rule ->
	* (that first at even and second at odd is maintained)
	* and the required element might be present in the right subarray
	* else in the left subarray
	**************************************************	
	* If mid = odd : Check mid - 1, then it means
	* (that first at even and second at odd is maintained)
	* and the required element might be present in the right subarray
	* else in the left subarray
	*/

     static int findEleBest(int A[], int n)
	 {
		 int start = 0;
		 int end = n-1;
		 
		 while(start <= end)
		 {		 
			 if(start == end)
				 return A[start];
			 
			 int mid = start + (end-start)/2;
			 
			 if(mid % 2 == 0)
			 {
				 if(A[mid] == A[mid+1])
					 start = mid + 2;
				 else
					 end = mid;
			 }
			 else if(mid % 2 != 0)
			 {
				 
					 if(A[mid] == A[mid-1])
						 start = mid + 1; //subtract 1; from above logic
					 else
						 end = mid-1; // subtract 1; from above logic
			 }
		 }
		 
		 return -1;
	 }

	public static void main (String[] args)
	{
		int A[] = {1, 1, 3, 3, 4,7, 7, 8, 8, 9, 9};
		int n = A.length;
		
		out.println(findEleBest(A, n));
	}
}

