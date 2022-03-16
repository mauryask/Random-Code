//arraycopy() method
public class ArrayCopy
{
	public static void main(String [] args)
	{
		int arr[] = new int[]{1,4,5,7,8,9,6,3,2,4,5};
		int arrx[] = new int[6];
		
		/**
		* @param arr : source array
		* @param arrx : destination array 
		* @param 1 : from which index you want to copy the elemnts of sourec array
		* @param 0 : starting index of the destination array 
		* @param 6 : size of the destination array
		*/
		
		System.arraycopy(arr,1, arrx,0, 6);
		
		for(int x : arrx)
		System.out.print(x+" ");
	}
}