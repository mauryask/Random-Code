/*
Very Important
* T(n) : O(n)
* S(n) : O(1)
***********
https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
*/


public class RowWithMAx1s 
{
	static int m = 4, n = 4;

	static int rowWithMax1s(int mat[][])
	{
	     // if no row has 1	
		int maxRow = -1;
		
		int i=0, j = n-1;
		
		while(i<m && j>=0)
		{
			if(mat[i][j] == 1)
			{
				maxRow = i;
				j--;
			}
			else
				i++;
		}
		
		return maxRow;
	}

	public static void main(String[] args)
	{
		int mat[][] = { { 0, 0, 0, 1 },
                        { 0, 1, 1, 1 },
                        { 1, 1, 1, 1 },
                        { 0, 0, 0, 0 } };
						
		System.out.println(rowWithMax1s(mat));
	}
}
