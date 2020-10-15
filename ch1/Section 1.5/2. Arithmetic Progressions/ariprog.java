/*
ID: peterya2
LANG: JAVA
TASK: ariprog
*/
import java.io.*;
import java.util.*;

class ariprog {
    // test 9: 25 250 - 3.453 secs
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("ariprog.in"));
        PrintWriter out = new PrintWriter(new File("ariprog.out"));

        int n = s.nextInt(); // length of progression
        int m = s.nextInt(); // upper bound for p, q bisquares

        // set is too slow
        // boolean[] is faster
        boolean[] bisquares = getBisquares(m); // O(m^2)

        boolean solFound = false;
        int max = m * m * 2;

        // O(m^3*n)
        for (int b = 1; b <= max; b++) {
            for (int a = 0; a + b * (n - 1) <= max; a++) {
                int sum = a;
                int i = 0;

                while (i < n) {
                    if (!bisquares[sum] || sum > max) {
                        break;
                    }
                    else {
                        sum += b;
                        i++;
                    }
                }

                if (i == n) {
                    out.println(a + " " + b);
                    solFound = true;
                }
            }
        }

        if (!solFound) {
            out.println("NONE");
        }

        out.close();
    }

    private static boolean[] getBisquares(int m) {
        boolean[] res = new boolean[m * m * 2 + 1];

        for (int p = 0; p <= m; p++) {
            for (int q = p; q <= m; q++) {
                res[p * p + q * q] = true;
            }
        }

        return res;
    }
}