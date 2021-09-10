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
		// Initialize first row as row with max 1s
		int j,max_row_index = 0;
		j = n - 1;

		for (int i = 0; i < m; i++) 
		{
			// Move left until a 0 is found
			while (j >= 0 && mat[i][j] == 1) 
			{
				j = j - 1; 
			  // Update max_row_index
				max_row_index = i; 
			}
		}
		if(max_row_index==0&&mat[0][n-1]==0)
			return -1;
		return max_row_index;
	}

	public static void main(String[] args)
	{
		int mat[][] = { { 0, 0, 0, 1 },
						{ 0, 1, 1, 1 },
						{ 0, 0, 0, 1 },
						{ 0, 0, 0, 0 } };
						
		System.out.println(rowWithMax1s(mat));
	}
}
