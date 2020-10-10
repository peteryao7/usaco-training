/*
ID: peterya2
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

class milk {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("milk.in"));
        PrintWriter out = new PrintWriter(new File("milk.out"));

        int milk = s.nextInt();
        int n = s.nextInt();

        int[][] farmers = new int[n][2];

        for (int i = 0; i < n; i++) {
            int[] pair = new int[2];
            pair[0] = s.nextInt();
            pair[1] = s.nextInt();
            farmers[i] = pair;
        }

        Arrays.sort(farmers, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });

        int cost = 0;
        for (int i = 0; i < farmers.length && milk > 0; i++) {
            cost += farmers[i][0] * Math.min(milk, farmers[i][1]);
            milk -= Math.min(milk, farmers[i][1]);
        }

        out.println(cost);
        out.close();
    }
}