/*
* T(n) : O(n * log n)
* S(n) : O(n)
*/
/*
* The idea is to keep number of elemnts  in maxHeap equal or 1 greater than the number of elemnts in minHeap 
* i.e. num(maxHeap) = num(minHeap) or num(maxHeap) = num(minHeap) + 1
*/

import static java.lang.System.*;
import java.util.*;

public class MedianOfRunningStream 
{
	static PriorityQueue<Integer> maxHeap = 
	new PriorityQueue<>(Collections.reverseOrder());
	
	static PriorityQueue<Integer> minHeap = 
	new PriorityQueue<>();
 	
	static double findMedian()
	{
		if(maxHeap.size() == minHeap.size())
			return (double)(maxHeap.peek() + minHeap.peek())/2.0;
		else 
			return maxHeap.peek();
	}

	static void insertNum(int num)
	{
		if(maxHeap.isEmpty() || maxHeap.peek() >= num)
			maxHeap.add(num);
		else
			minHeap.add(num);
		
		if(maxHeap.size() > minHeap.size()+1)
			minHeap.add(maxHeap.poll());
		else if(maxHeap.size() < minHeap.size())
			maxHeap.add(minHeap.poll());
	}
	
	public static void main(String args[])
	{
	  insertNum(5);
	  insertNum(15);
	  insertNum(1);
	  out.println(findMedian());
	  insertNum(3);
	  insertNum(2);
	  out.println(findMedian());
	}
}



//O(n^2) code using binary search no the tp of the insertion sorting
/*

    static int  getPosition(List<Integer> list, int target)
	{
		int start = 0;
		int end = list.size() - 1;
		
		while(start <= end)
		{
			int mid = start + (end - start) / 2;
			
			if(list.get(mid) == target)
				return mid;
			else if(list.get(mid) > target)
				end = mid - 1;
			else 
				start = mid + 1;
		}
		
		return start;
	}
	
	static double findMedian(List<Integer> list)
	{
		int n = list.size();		
		if(n % 2 == 0)
			return (list.get(n/2-1) + list.get(n/2)) / 2.0;
		return list.get(n/2);
	}
    
   public static void main(String [] args)
   {
       List<Integer> list = new ArrayList<>();
	   
	   while(true)
	   {
		    int nextEle = new Scanner(in).nextInt();
		   
		    if(nextEle == -1)
			   break;
		   
		    if(nextEle == 0)
			{
				out.println("Median: "+findMedian(list));
				continue;
			}
		   
		    int position = getPosition(list, nextEle);
	   
	        out.println("Before: "+list);
	   
	        out.println("Position: "+position);
	        
			list.add(position, nextEle);
	   
	        out.println("After: "+list);
	   }   
   }
*/