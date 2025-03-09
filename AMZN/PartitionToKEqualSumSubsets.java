/*
* T(n) : (k * 2 ^ n)
* S(n) : O(n : the height of the recursion tree)
 */

import static java.lang.System.*;
import java.util.*;

public class PartitionToKEqualSumSubsets {

    static boolean isPossible(int[] arr, int start, int k, int currentSum, int targetSum, boolean[] visited) {
        // If all ths subsets have been found return  true
        if (k == 0) {
            return true;
        }
        // If targetSum achieved for a subset, find the rest of the subsets  
        if (currentSum == targetSum) {
            return isPossible(arr, 0, k - 1, 0, targetSum, visited);
        }

        for (int i = 0; i < arr.length; i++) {
            // Check if inclusing the current element does not voilate the targetSum
            if (!visited[i] && currentSum + arr[i] <= targetSum) {
                // Mark ith element it as taken
                visited[i] = true;

                // If targetSUm found return from here
                if (isPossible(arr, i + 1, k, currentSum + arr[i], targetSum, visited)) {
                    return true;
                }

                // Undo the above if taking this element does not makes the targetSum
                visited[i] = false;
            }
        }

        return false;
    }

    static public boolean isKPartitionPossible(int[] arr, int k) {
        int n = arr.length;

        // In this case it is mathematicaly impoissible to asign at least one element to k subsets
        if (n < k) {
            return false;
        }

        // Case: if n is zero (not possible to get non-emptty subsets as per given conditions)
        // Case: If k is zero (Statement is contradictory: dividing a subset into 0 subsets)
        if (n == 0 || k == 0) {
            return false;
        }

        int sum = 0;

        for (int x : arr) {
            sum += x;
        }

        // If sum is perfectly didvisible by k then there is possibility but not gauranteed that 
        // k equal sum subset division is possible (So we have to verify our claim)
        if (sum % k != 0) {
            return false;
        }

        // If the division is possible then the sum of each subset should be as below  
        int targetSum = sum / k;

        boolean[] visited = new boolean[n];

        // It is ot mandatory but it is an important ptimization
        // Sorting elements will significantly reduce the search space
        Arrays.sort(arr);

        return isPossible(arr, 0, k, 0 /*currentSum*/, targetSum, visited);
    }

    public static void main(String[] args) {
        int A[] = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        out.println(isKPartitionPossible(A, k));
    }
}
