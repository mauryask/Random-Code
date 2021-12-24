import static java.lang.System.*;
import java.util.*;

class Platform 
{
	int arrival;
	int departure;
	
	Platform(int arrival, int departure)
	{
		this.arrival = arrival;
		this.departure = departure;
	}
}

public class MinimumPlatformsNeeded 
{
	/*
	* Bruteforce solution
	* T(n ): O(n*n)
	* S(n) : O(1)
	**/
	static int minPlatforms(int[] arr, int[] dep, int n)
	{
		int minPlat = 0;
		int platform = 0;
		
		for(int i=0; i<n; i++)
		{
			platform = 1;
			
			for(int j=i+1; j<n; j++)
			{
				if((arr[j]<= dep[i] && dep[i] <= dep[j])
					|| (arr[i] <= arr[j] && arr[j] <= dep[i]))
					{
						platform++;
					}
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

    static int minPlat2(int[] arr, int[] dep,int n)
	{
		Queue<Integer> q = new PriorityQueue<>(
		(a, b)->{
			return a - b;
		});
		
		List<Platform> list = new ArrayList<>();
		for(int i=0; i<n; i++)
			list.add(new Platform(arr[i], dep[i]));
		
		Collections.sort(list, (a, b)->{
			return a.arrival - b.arrival;
		});
				
		int platform = 1;
			
	    q.add(list.get(0).departure);
		
		for(int j=1; j<n; j++)
		{
		   if(list.get(j).arrival > q.peek())
			   q.remove();
		   else
			   platform++;
		   
		   q.add(list.get(j).departure);
		}
		
		return platform;
	}
	
	
	/*
	* Best solution
	* T(n) : O(n*log n)
    * S(n) : O(1)	
	*/
	
	static int bestSolution(int[] arr, int[] dep, int n)
	{
		int minPlat = 1;
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int i = 0;
		int j = i+1;
	
		while(j<n)
		{
		   if(arr[j] > dep[i])
		   {
			   i++;
			   j++;
		   }
		   else
		   {
			   j++;
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
		
		out.println(bestSolution(arr, dep, n));
	}
}