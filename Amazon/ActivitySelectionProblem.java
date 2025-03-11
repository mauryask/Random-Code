/*
* T(n) : O(n * log n)
* S(n) : O(n)
* https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 */

import static java.lang.System.*;
import java.util.*;

class Activity {

    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ActivitySelectionProblem {

    /*
	 The main idea is to select the maximum number 
	 of non-overlapping activities. The greedy strategy
	 is to always choose the activity that finishes
	 the earliest, which allows you to leave as much 
	 room as possible for the remaining activities.
	**/
    static int maxActivity(int[] start, int[] end, int n) {
        List<Activity> acivityList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            acivityList.add(new Activity(start[i], end[i]));
        }
        /*
		* The person will always try to choose the 
		* activity that finishes fisrt, since he
		* is intrested to complete as many activities 
		* as possible (standard greedy problem)
         */

        Collections.sort(acivityList, (a, b) -> a.end - b.end);

        // initialized with 1 since 
        // Atleast one activity can always be finished
        int maxAct = 1;
        int i = 0, j = i + 1; // This valriable indicates the selected activity

        while (j < n) {
            // Check if next activity can be selected for execution
            if (acivityList.get(i).end <= acivityList.get(j).start) {
                maxAct++;
                i = j; // Select that activity
            }
        }

        return maxAct;
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 2, 5};//{1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 3, 6};//{2, 4, 6, 7, 9, 9};
        int n = start.length;
        out.println("\nMax activities : " + maxActivity(start, end, n));
    }
}
