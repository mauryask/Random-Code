/*
* T(n) : O(n)
* S(n) : O(n)
 */

import static java.lang.System.*;
import java.util.*;

public class LongestConsecutiveSubSequnce {

    static int maxLength = 0;

    static void getMaxLength(int[] A, int n) {
        Set<Integer> set = new HashSet<>();
        /*
		* Each every element is a consecutive
		* subsequence of size 1 so put true in the set
         */
        for (int x : A) {
            set.add(x);
        }

        /*
		* For each element that is starting of its 
		* subsequence find max consecutive length
         */
        for (int x : A) {
            if (!set.contains(x - 1)) {
                int temp = x;
                int max = 0;

                while (set.contains(temp)) {
                    max++;
                    temp++;
                }

                maxLength = Math.max(max, maxLength);
            }
        }
    }

    // Brute force solution 
    // T(n) : O(n*log n)
    // S(n) : O(n) 
    static int getLength(int[] A, int n) {
        Arrays.sort(A);
        int i = 0, j = 1;
        int maxLen = 1;
		int max = 1;

        while (j < n) {
            // If duplicate elemet found just ignore it 
			if(A[i] == A[j]){
				j++;
				continue;
			}

            // Check the next element with current
			if (A[j] == A[i] + 1) {
                max++;				
				maxLen = Math.max(max, maxLen);
            }else{ // If above condition not valid
			// Consider it as starting element of another subsequence
			// reset the max to 1
				max = 1;				
			}
            
			i = j;
            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int A[] = {1, 9, 8, 7, 9, 3, 10, 4, 11, 2};
        int n = A.length;
        /*getMaxLength(A, n);
		out.println(maxLength);*/

        out.println(getLength(A, n));
    }
}
