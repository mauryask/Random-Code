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
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
 	
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