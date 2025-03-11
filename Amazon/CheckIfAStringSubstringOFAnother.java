/*
* This is not the actual solution to this problem 
* It should be solved using KMP algorithm
* Time complexity is same for both : O(m*n)
* but space complexity is better in KMP : O(1)
* https://www.geeksforgeeks.org/check-string-substring-another/
**/

import static java.lang.System.*;

public class CheckIfAStringSubstringOFAnother {

    static boolean isSubstring(String s1, String s2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        int max = 0;
        int x = 0, y = 0;

        boolean isFound = false;

        for (int i = 1; i < m + 1; i++) {
            isFound = false;

            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] == n) {
                        isFound = true;
                        x = i;
                        y = j;
                        break;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }

            if (isFound) {
                break;
            }
        }

        if (isFound) {
            getIndex(s1, s2, x, y, dp);
        }
        return isFound;
    }

    static void getIndex(String s1, String s2, int x, int y, int[][] dp) {
        while (dp[x][y] != 0) {
            if (s1.charAt(x - 1) == s2.charAt(y - 1)) {
                x--;
                y--;
            }
        }

        System.err.println("Starting index: " + x);
    }

    public static void main(String[] args) {
        String s1 = "pracicectice";
        String s2 = "ice";
        int m = s1.length();
        int n = s2.length();
        out.println(isSubstring(s1, s2, m, n));
    }
}
