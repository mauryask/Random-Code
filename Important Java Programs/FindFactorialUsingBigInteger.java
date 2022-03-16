import java.util.Scanner;
import java.math.BigInteger;
import static java.lang.System.*;

public class FindFactorialUsingBigInteger
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(in);
	   int n = sc.nextInt();
	   
	   fact(n);
	}
	
	static void fact(int n)
	{
		BigInteger f = BigInteger.ONE;
		BigInteger num = BigInteger.valueOf(n);
		for(int i = n;i>0; i--)
		{
			f = f.multiply(BigInteger.valueOf(i));
		}
		out.println(f);
	}
}
