/*
ID: peterya2
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.*;

class skidesign {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("skidesign.in"));
        PrintWriter out = new PrintWriter(new File("skidesign.out"));

        int n = s.nextInt();
        int[] heights = new int[n];

        int minHeight = 100;
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            heights[i] = s.nextInt();
            minHeight = Math.min(heights[i], minHeight);
            maxHeight = Math.max(heights[i], maxHeight);
        }

        if (maxHeight - minHeight <= 17) {
            out.println(0);
            out.close();
            return;
        }

        int minCost = Integer.MAX_VALUE;

        // window of size 17
        for (int i = 17; i <= maxHeight; i++) {
            int curCost = 0;

            for (int j = 0; j < n; j++) {
                if (heights[j] < i - 17) {
                    curCost += (i - 17 - heights[j]) * (i - 17 - heights[j]);
                }
                else if (heights[j] > i) {
                    curCost += (heights[j] - i) * (heights[j] - i);
                }
            }

            minCost = Math.min(minCost, curCost);
        }

        out.println(minCost);
        out.close();
    }
}