/*
* https://www.geeksforgeeks.org/reduce-the-string-by-removing-k-consecutive-identical-characters/
* Very Imp
* T(n) : O(n)
* S(n) : O(n)
 */
import static java.lang.System.*;
import java.util.*;

public class RemoveKConsecutiveDuplicateCharactersFromString {
    //Good approach

    static String reducedString(int k, String s) {
        int n = s.length();

        if (n == 0 || k == 1) {
            return "";
        }

        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek()[0] == ch) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{ch, 1});
            }
        }

        for(int[] arr : stack) {
            char ch = (char) arr[0];
            int freq = arr[1];

            while (freq-- > 0) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    //Best approach as array operations are faster than stack 
    static String reducedString2(int k, String s) {
        int n = s.length();

        if (n == 0 || k == 1) {
            return "";
        }

        char[] arr = s.toCharArray();
        int[] count = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            arr[j] = arr[i];
            if (j > 0 && arr[j] == arr[j - 1]) {
                count[j] = count[j - 1] + 1;
            } else {
                count[j] = 1;
            }

            if (count[j] == k) {
                j -= k; // Remove k characters
            }
            j++;
        }

        return new String(arr, 0, j);
    }

    public static void main(String[] args) {
        // String str = "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
		String str = "geeksforgeeks";
        int k = 2;
        String rsltStr = reducedString(k, str);
        out.println(rsltStr);
    }
}
