public class JaggedArray
{
	public static void main(String [] args)
	{	
	   //jagged array (array having different number of columns)
        int a[][]=  new int[3][];
		a[0] = new int[4];
		a[1] = new int[3];
		a[2] = new int[2];
		
		System.out.println(a.length);
	}
}