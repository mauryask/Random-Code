/*
* Other Approaches
******************
* Bruteforce search in whole matrix
* by using two loops: O(n*n)
******************
* Apply binary search on each row or column: O(n*log n)
*/

// https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/

/*
* Best Solution
***************
* Time complexity: O(n)
* Space complexity: O(1)
*/


import static java.lang.System.*;

public class SearchInASortedMatrix
{
	static boolean isFound(int A[][], int m, int n, int target)
	{
		int i = 0; 
		int j = n-1;
		
		while(i<m && j>=0)
		{
			if(A[i][j] == target)
				return true;
			
			if(A[i][j] > target)
				j--;
			else if(A[i][j] < target)
				i++;
		}
		
		return false;
	}
	
	public static void main(String [] args)
	{
		int A[][] = {{10,20,30,40},
					{15,25,35,45},
					{27,29,37,48},
					{32,33,39,50}};
		int m = 4;
		int n = 4;

		out.println(isFound(A, m, n, 39));		
	}
}