/*
* T(n) : O(n*log n)
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

class Activity 
{
	int st;
	int en;
	
	Activity(int st, int en)
	{
		this.st = st;
		this.en = en;
	}
}

public class ActivitySelectionProblem 
{
	static int maxActivity(int[] start, int[] end, int n)
	{
		List<Activity> list = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			list.add(new Activity(start[i], end[i]));
		/*
		* The person will always try to choose the 
		* activity that finishes fisrt, since he
		* is intrested to complete as many activities 
		* as possible (standard greedy problem)
		*/
		
		Collections.sort(list, (a,b)->{
			return a.en - b.en;
		});
		
		// initialized with 1 since 
		// he is always going to finish the first 
		// activity
		
		int maxAct = 1;
		out.print("("+list.get(0).st +", "+list.get(0).en+") ");
		
		int i = 0;
		
		for(int j=1; j<n; j++)
		{
			if(list.get(j).st >= list.get(i).en)
			{
				maxAct++;
				out.print("("+list.get(j).st +", "+list.get(j).en+") ");
				i=j;
			}
		}
		
		return maxAct;
	}
	
	public static void main(String [] args)
	{
		int start[] = {1, 3, 0, 5, 8, 5};
		int end[] = {2, 4, 6, 7, 9, 9};
		int n = start.length;
		
		out.println("\nMax activities : "+maxActivity(start, end, n));
	}
}