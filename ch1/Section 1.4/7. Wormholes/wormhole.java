/*
ID: peterya2
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;

class wormhole {
    static int n;
    static int[] X;
    static int[] Y;
    static int[] partner;
    static int[] nextRight;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("wormhole.in"));
        PrintWriter out = new PrintWriter(new File("wormhole.out"));

        n = s.nextInt();
        // use 1-indexing
        // 0 is used as a placeholder for unpartnered wormholes
        X = new int[n + 1];
        Y = new int[n + 1];
        partner = new int[n + 1];
        nextRight = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            X[i] = s.nextInt();
            Y[i] = s.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[j] > X[i] && Y[i] == Y[j]) {
                    if (nextRight[i] == 0 || X[j] - X[i] < X[nextRight[i]] - X[i]) {
                        nextRight[i] = j;
                    }
                }
            }
        }

        // for (int i = 0; i < nextRight.length; i++)
        //     System.out.println("X,Y = " + X[i] + ", " + Y[i] + ", i = " + i + ", nextRight[i] = " + nextRight[i]);

        int res = count();
        out.println(res);
        out.close();
    }

    private static int count() {
        int total = 0;
        int i;

        for (i = 1; i <= n; i++) {
            if (partner[i] == 0)
                break;
        }

        // System.out.println("i = " + i);

        if (i > n) {
            return cycleExists();
        }

        // backtracking, look for other partnered wormholes
        for (int j = i + 1; j <= n; j++) {
            if (partner[j] == 0) {
                partner[i] = j;
                partner[j] = i;
                total += count();
                partner[i] = 0;
                partner[j] = 0;
            }
        }

        return total;
    }

    private static int cycleExists() {
        // for (int i = 1; i <= n; i++) {
        //     System.out.println("i = " + i + ", partner[i] = " + partner[i]);
        // }

        for (int i = 1; i <= n; i++) {
            int pos = i;
            // System.out.println("pos = " + pos);

            for (int count = 0; count < n; count++) {
                pos = nextRight[partner[pos]];
                // System.out.println("look for cycle pos = " + pos);
            }

            // System.out.println("last pos = " + pos);
            if (pos != 0)
                return 1;
        }

        return 0;
    }
}