import static java.lang.System.*;
import java.util.*;

public class MinimumPlatformsNeeded 
{
	/*
	* Bruteforce solution
	* T(n ): O(n*n)
	* S(n) : O(1)
	**/
	static int minPlatforms(int[] arr, int[] dep, int n)
	{
		int minPlat = 1;
		int platform = 0;
		
		for(int i=0; i<n; i++)
		{
			platform = 1;
			
			for(int j=0; j<n; j++)
			{			
				if (i!=j && arr[i] >= arr[j] && dep[j] >= arr[i])
						platform++;
			}
				
			minPlat = Math.max(minPlat, platform);					
		}		
		
		return minPlat;
	}
	
	/*
	* Good but not best solution
	* T(n) : O(n *log n)
	* S(n) : O(n)
	*/

    static class Time  
	{
		int arr;
		int dep;
		
		Time(int arr, int dep)
		{
			this.arr = arr;
			this.dep = dep;
		}
	}

    private static int minPlat2(int a[], int d[], int n)
	{
		Queue<Integer> q = new PriorityQueue<>();//By deafult is Min-Heap
		Time t[] = new Time[n];
		
		for(int i=0; i<n; i++)
			t[i] = new Time(a[i], d[i]);
		
		Arrays.sort(t, (x, y)->{
			return x.arr - y.arr;
		});
		
		q.add(t[0].dep);
		
		int minPlatform = 1;
		
		for(int i=1; i<n; i++)
		{
			if(t[i].arr <= q.peek())
				minPlatform++;
			else 
			  q.poll();
			
			q.add(t[i].dep);
		}			
		
		return minPlatform;
	}	
	
	/*
	* Best solution
	* T(n) : O(n*log n)
    * S(n) : O(1)	
	*/
	
	static int bestSolution(int[] arr, int[] dep, int n)
	{
		int minPlat = 1;
		// sorting the arrival times because the
		// train that arrives first will be assigned the 
		// platform first
		
		Arrays.sort(arr);
		
		// sorting ther departure time because 
		// when train the train that will leave  
		// the platform the platform is going to be empty
		Arrays.sort(dep);
				
		int j = 0; // pointer to dept array
	    int i = 1; // pointer arr array
		
		while(i<n)
		{
		   if(arr[i] > dep[j])
		   {
			   i++;
			   j++;
		   }
		   else
		   {
			   i++;
			   minPlat++;
		   }
		}
		
		return minPlat;
	}
	
	public static void main(String [] args)
	{
		int arr[] = {900, 1100, 1235};
		int dep[] = {1000, 1200, 1240};
		int n = arr.length;		
		out.println(minPlatforms(arr, dep, n));
	}
}