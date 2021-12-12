import static java.lang.System.*;
import java.util.*;

class Meeting 
{
	int start;
	int end;
	
	Meeting(int start,int end)
	{
	   this.start = start;
	   this.end = end;	   
	}
}

public class MaxMeetingsThatCanBeCompleted 
{
	static int maxMeets(int st[], int et[], int n)
	{
		List<Meeting> list = new ArrayList<>(); 
		for(int i= 0; i<n; i++)
			list.add(new Meeting(st[i], et[i]));
		
		Collections.sort(list, (a, b
		)->{
			if(a.end ==  b.end)
			   return a.start - b.start;
		     else 
				 return a.end - b.end;
		});
		
		int i = 0; 
		int j = 1;
        int maxMeet = 0;		
		
		List<Meeting> result = new ArrayList<>();
				
		while(i<n && j<n)
		{
			if(list.get(i).end < list.get(j).start)
			{
				maxMeet++;
				result.add(list.get(i));
				i = j;
				j++;
			}
			else
				j++;
		}
				
        result.add(list.get(i));		
		for(Meeting m : result)
			out.println(m.start+"., "+m.end);
		
		return maxMeet+1;
	}
	
	public static void main(String [] args)
	{
		int[] st = {1, 3, 0, 5, 8, 5}; // start time 
		int[] et = {2, 4, 6, 7, 9, 9}; // end time 
		int n = st.length;
		out.println(maxMeets(st, et, n));
	}
}