/*
* T(n) : O(n*n)
* S(n) : O(n)
** Same as the longest increasing subsequence 
** https://www.geeksforgeeks.org/weighted-job-scheduling/
*/

import static java.lang.System.*;
import java.util.*;

class Job
{
	int start;
	int end;
	int profit;
	
	Job(int start, int end, int profit) 
	{
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}

public class WeightedJobSceduling
{	
	static int findMaxProfit(List<Job> jobs)
	{
		Collections.sort(jobs, (a, b)-> (a.end-b.end));
		int n = jobs.size();		
		int  maxProfit[] = new int[n];
		
		int max = 0;
		
		for(int i=0; i<n; i++)
			maxProfit[i] = jobs.get(i).profit;
		
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(jobs.get(i).start >= jobs.get(j).end
				&& maxProfit[i] < maxProfit[j] + jobs.get(i).profit)
					maxProfit[i] = maxProfit[j] + jobs.get(i).profit;
			}
			
			max = Math.max(max, maxProfit[i]);
		}
		
		return max;
	}
	
	public static void main(String [] args)
	{
	   List<Job> jobs = new ArrayList<>();
	   
	   jobs.add(new Job(1,2,50));
	   jobs.add(new Job(3,5,20));	   
	   jobs.add(new Job(6,9,100));
	   jobs.add(new Job(2,100,200));
	  
	   out.println(findMaxProfit(jobs));
	}
}