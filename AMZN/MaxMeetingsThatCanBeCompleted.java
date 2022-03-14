import static java.lang.System.*;
import java.util.*;

/*
* T(n) : O(n*logn)
* S(n) : O(n)
*/

class Meeting 
{
	int start;
	int end;
	int index;
	
	Meeting(int start,int end,int index)
	{
	   this.start = start;
	   this.end = end;	   
	   this.index = index;
	}
}

public class MaxMeetingsThatCanBeCompleted 
{
	static int maxMeets(int st[], int et[], int n)
	{
		List<Meeting> list = new ArrayList<>(); 
		
		for(int i= 0; i<n; i++)
			list.add(new Meeting(st[i], et[i], i));
		
		Collections.sort(list, (a, b) -> (a.end - b.end));
	        
		List<Meeting> result = new ArrayList<>();
		
		result.add(list.get(0));
		
		int lastMeetEnd = list.get(0).end;
				
		for(int i=1; i<n; i++)
		{
			if(list.get(i).start > lastMeetEnd)
			{
				result.add(list.get(i));
				lastMeetEnd = list.get(i).end;
			}
		}
		
		for(Meeting m : result)
			out.println(m.start+"., "+m.end);

		// total meets that can be completed 
		// is the size of the result list
		return result.size();
	}
	
	public static void main(String [] args)
	{
		int[] st = {1, 3, 0, 5, 8, 5}; // start time 
		int[] et = {2, 4, 6, 7, 9, 9}; // end time 
		int n = st.length;
		out.println(maxMeets(st, et, n));
	}
}