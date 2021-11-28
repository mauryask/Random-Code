/*
* T(n) : O(2^n)
* S(n) : O(n*n)
*/
import static java.lang.System.*;
import java.util.*;

/*
* Zig-zag traversal
* works for square matrix : if n is even only
*/
public class ZigzagTraversal
{
	static void printTraversal(int[][] A, int n)
	{
		int i = 0;
		int j = 0;
		
        //left upper triangular region(including right inclined diagonal)		
		for(i=0; i<n; i++)
		{
			int k = 0;
				for(j=i; j>=0; j--)
				{
					if(i%2==0)
						out.print(A[j][k++]+" ");
					else
						out.print(A[k++][j]+" ");
				}
			out.println();
		}
		
		// print lower triangular reigion:(leave diagonal)
		
		int x = i-1;
		int y = j+2;
		
         for(i=y; i<n; i++)
		 {
			 int k = x;
			 
			 for(j=i; j<n; j++)
			 {
				 if(i%2==0)
					 out.print(A[j][k--]+" ");
				 else
					 out.print(A[k--][j]+" ");
			 }
			 
			 out.println();
		 }			 
	}
	
	public static void main(String [] args)
	{
		int A[][] =
		{
			{1,  2, 3, 4, 5, 6, 7, 8},
			{9, 10,11,12,13,14,15,16},
			{17,18,19,20,21,22,23,24},
			{25,26,27,28,29,30,31,32},
			{33,34,35,36,37,38,39,40},
			{41,42,43,44,45,46,47,48},
			{49,50,51,52,53,54,55,56},
			{57,58,59,60,1,62,63,64},
		};
		
        printTraversal(A, 8);
	}
}