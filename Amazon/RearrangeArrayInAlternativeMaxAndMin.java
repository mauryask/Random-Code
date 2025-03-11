import static java.lang.System.*;
import java.util.*;

public class RearrangeArrayInAlternativeMaxAndMin {
    /*
	* T(n) : O(n) 
	* S(n) : O(n)
     */
    static void rearrange(int arr[]) {
        int n = arr.length;

        if (n <= 1) {
            return;
        }

        int res[] = new int[n];
        int start = 0, end = n - 1;
        int index = 0;

        Arrays.sort(arr);

        while (start <= end) {
            res[index] = arr[end];
            if (index + 1 < n) {
                res[index + 1] = arr[start];
            }

            start++;
            end--;
            index += 2;
        }
        // Update the original array values
        for (int i = 0; i < n; i++) {
            arr[i] = res[i];
        }
    }

    /*
	* T(n) : O(n*n)
	* S(n) : O(1)
     */
    static void sol2(int[] A, int n) {		
		if(n<=1)
		  return;
	  
		for(int i=0; i<n; i+=2){			 
			 int j = n-1;
			 int temp = A[j];
		     for(; j>i; j--){
				A[j] = A[j-1]; 
			 }
			 
            A[j] = temp;
		}

        for (int x : A) {
            out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = A.length;

        //reArrange(A, n);
        sol2(A, n);
    }
}
