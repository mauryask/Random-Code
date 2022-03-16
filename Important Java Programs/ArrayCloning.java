//array cloning (in case of single diemnsional array deep copy)
//in case of multi dimensional array shallow copy of the array is obtained
public class ArrayCloning 
{
	public static void main(String [] args)
	{
		//deep copy(cloning 1d array)
		int arr[] = new int[]{1,4,5,7,8,9,6,3,2,4,5};
		int arrx[] = arr.clone();
		
         arrx[2] = 100;         // not being reflected in arr (so deep copy)
		
		for(int x : arr)
		System.out.print(x+" ");	
	    System.out.println("\n"+(arr == arrx)); //#putput : false (hence deep copy)
		
		
		//shallow copy	(cloning 2d array)	
		int arr2[][] ={{1,7,8}, {4,8,6}};
		int arry[][] = arr2.clone();
		
		arry[0][2] = 45; //it is being reflected in arr2 (hence shallow copy)
		
		for(int i=0; i<2; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
	}
}