/*
* T(n) : O(m*n)
* S(n) : O(m*n)
** https://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/
*/

import static java.lang.System.*;
import java.util.*;

public class PrintTheElementsOfSortedMatrixRowAndColumnWise 
{
	static void printEle(int[][] A, int m,int n)
	{
		List<Integer> rslt = new ArrayList<>();
		List<Integer> tempList;
		
		for(int i=0; i<n; i++)
			rslt.add(A[0][i]);
		
		for(int i=1; i<m; i++)
		{
			int x = 0;
			int y = 0;
			tempList = new ArrayList<>();
			
			while(x < rslt.size() && y < n)
			{
		         if(rslt.get(x) < A[i][y])
					tempList.add(rslt.get(x++));
				 else
					 tempList.add(A[i][y++]);
			}
			
			while(x<rslt.size())
				tempList.add(rslt.get(x++));
			while(y<n)
			   tempList.add(A[i][y++]);
		   
			rslt = tempList;
		}
		
		for(int ele : rslt)
			out.print(ele+" ");
	}
	
	public static void main(String [] args)
	{
		int A[][] = {{10,20,30,40},
			         {15,25,35,45},
				     {27,29,37,48},
					 {32,33,39,50}};
		int m = A.length;
		int n = A[0].length;
		
		printEle(A, m, n);
	}
}