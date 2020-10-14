/*
ID: peterya2
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

class combo {
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("combo.in"));
        PrintWriter out = new PrintWriter(new File("combo.out"));

        n = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        int z = s.nextInt();

        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (isClose(a, b, c, i, j, k) || isClose(x, y, z, i, j, k))
                        res++;
                }
            }
        }

        out.println(res);
        out.close();
    }

    private static boolean isClose(int l1, int l2, int l3, int c1, int c2, int c3) {
        return withinTwo(l1, c1) && withinTwo(l2, c2) && withinTwo(l3, c3);
    }

    private static boolean withinTwo(int a, int b) {
        int diff = Math.abs(a - b);
        return diff <= 2 || diff >= n - 2;
    }
}