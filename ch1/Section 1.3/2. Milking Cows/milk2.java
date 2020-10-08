/*
ID: peterya2
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
    public static void main (String [] args) throws IOException {
        Scanner s = new Scanner(new File("milk2.in"));
        PrintWriter out = new PrintWriter(new File("milk2.out"));

        int n = s.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            int[] interval = new int[2];
            interval[0] = s.nextInt();
            interval[1] = s.nextInt();
            intervals[i] = interval;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        int maxGap = 0;
        int maxInterval = prevEnd - prevStart;

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];

            if (prevEnd >= cur[0]) {
                prevEnd = Math.max(prevEnd, cur[1]);
            }
            // prevEnd < cur[0], two different intervals
            else {
                maxInterval = Math.max(maxInterval, prevEnd - prevStart);
                maxGap = Math.max(maxGap, cur[0] - prevEnd);
                prevStart = cur[0];
                prevEnd = cur[1];
            }
        }

        out.println(maxInterval + " " + maxGap);
        out.close();
    }
}