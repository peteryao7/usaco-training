/*
ID: peterya2
LANG: JAVA
TASK: numtri
*/
import java.io.*;
import java.util.*;

class numtri {
    // test 9: n = 1000 - 1.295 secs
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("numtri.in"));
        PrintWriter out = new PrintWriter(new File("numtri.out"));

        int n = s.nextInt();
        int[][] triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];

            for (int j = 0; j <= i; j++) {
                triangle[i][j] = s.nextInt();
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // if/else comparison is faster than Math.max()
                if (triangle[i + 1][j] > triangle[i + 1][j + 1])
                    triangle[i][j] += triangle[i + 1][j];
                else
                    triangle[i][j] += triangle[i + 1][j + 1];
                //triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        out.println(triangle[0][0]);
        out.close();
    }
}