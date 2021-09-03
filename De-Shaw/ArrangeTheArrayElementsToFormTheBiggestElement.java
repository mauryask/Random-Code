/*
* https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
**/
import static java.lang.System.*;
import java.util.*;

public class ArrangeTheArrayElementsToFormTheBiggestElement
{
	static String biggestNumber(int A[], int n)
	{
		String arr[] = new String[n];
				
		for(int i=0;i<n;i++)
		{
			 arr[i] = A[i]+"";
		}

		Arrays.sort(arr,(a, b)->{
			String ab = a+b;
			String ba = b+a;
			return ab.compareTo(ba) > 0 ? -1 : 1;
		});
		
		StringBuilder sb = new StringBuilder();
		for(String str : arr)
			sb.append(str);
		
		return sb.toString();
	}
	
	public static void main(String [] args)
	{
		int A[] = {54, 546, 548, 60};
		out.println(biggestNumber(A, A.length));
	}
}