// Given an input array with lexicograpically sorted strings into it
// For a given string called prefix 
// Count number of strings that has given prefix as given prefix string
// Expected time compelxity: O(log |n|)
// Space compelxity: O(1)

// Idea is to apply binary search

import static java.lang.System.*;

public class CountStringsWithGivenPrefix{
	// Get the first and last occurance of the strings with the given prefix
	static int getOccurance(String[] input, String prefix, boolean flag){
		int start = 0;
		int end = input.length - 1;
		int result = -1;
		
		while(start <= end){
			int mid = start + (end - start) / 2;
			String str = input[mid];
			
			if(str.startsWith(prefix)){
				result = mid;
				if(flag) // flag is true: for the first occurance
				   end = mid - 1;
			    else // For last occurance
				   start = mid + 1;
			}else if(str.compareTo(prefix) < 0){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		
		return result;
	}
	
	static int getCount(String[] input, String prefix){
		int firstOccurance =  getOccurance(input, prefix, true);
		if(firstOccurance == -1)
		   return 0;
	   
	    int lastOccurance = getOccurance(input, prefix, false);
		
		return lastOccurance - firstOccurance + 1;
	}
	
	public static void main(String[] args){
		String[] input = {"a", "ab", "c", "cd", "cdf", "ef", "efg", "fkj"};
		String prefix = "c";
		out.println(getCount(input, prefix));
	}
}