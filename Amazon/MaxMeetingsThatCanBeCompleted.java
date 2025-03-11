
import static java.lang.System.*;
import java.util.*;

/*
* T(n) : O(n*logn)
* S(n) : O(n)
** Same as activity selection problem
 */
public class MaxMeetingsThatCanBeCompleted {

    static ArrayList<Integer> maxMeetings(int[] S, int[] F) {
        int n = S.length;
        int[][] meetings = new int[n][3];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = S[i];  // Start time
            meetings[i][1] = F[i];  // End time
            meetings[i][2] = i + 1; // Meeting number
        }

        // Sort based on the end time of the meetings
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);
        // Store the result in the below list
        ArrayList<Integer> maxMeets = new ArrayList<>();

        //Select first meeting initially
        int i = 0, j = 1;
        maxMeets.add(meetings[i][2]);

        while (j < n) {

            if (meetings[i][1] < meetings[j][0]) {
                // Select ith meeting for completion
                i = j;
                // Add this meeting ID in the results
                maxMeets.add(meetings[j][2]);
            }
            j++;
        }

        // If the rsults needed to be in sorted order sort it
        Collections.sort(maxMeets);

        return maxMeets;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5}; // Start time 
        int[] end = {2, 4, 6, 7, 9, 9}; // End time         
        out.println(maxMeetings(start, end));
    }
}
