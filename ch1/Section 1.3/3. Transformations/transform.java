/*
ID: peterya2
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;

class transform {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter(new File("transform.out"));

        int N = s.nextInt();
        char[][] start = new char[N][N];
        char[][] end = new char[N][N];

        for (int i = 0; i < N; i++) {
            start[i] = s.next().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            end[i] = s.next().toCharArray();
        }

        if (Arrays.deepEquals(rotate(start), end))
            out.println(1);
        else if (Arrays.deepEquals(rotate(rotate(start)), end))
            out.println(2);
        else if (Arrays.deepEquals(rotate(rotate(rotate(start))), end))
            out.println(3);
        else if (Arrays.deepEquals(reflect(start), end))
            out.println(4);
        else if (Arrays.deepEquals(rotate(reflect(start)), end) ||
                 Arrays.deepEquals(rotate(rotate(reflect(start))), end) ||
                 Arrays.deepEquals(rotate(rotate(rotate(reflect(start)))), end))
            out.println(5);
        else if (Arrays.deepEquals(start, end))
            out.println(6);
        else
            out.println(7);

        out.close();
    }

    private static char[][] rotate(char[][] c) {
        int N = c.length;
        char[][] res = new char[N][N];

        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                char temp = c[i][j];
                res[i][j] = c[N - 1 - j][i];
                res[N - 1 - j][i] = c[N - 1 - i][N - 1 - j];
                res[N - i - 1][N - j - 1] = c[j][N - 1 - i];
                res[j][N - 1 - i] = temp;
            }
        }

        if (N % 2 == 1)
            res[N / 2][N / 2] = c[N / 2][N / 2];

        return res;
    }

    private static char[][] reflect(char[][] c) {
        int N = c.length;
        int M = N % 2 == 0 ? N / 2 : N / 2 + 1;
        char[][] res = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res[i][j] = c[i][N - j - 1];
                res[i][N - j - 1] = c[i][j];
            }
        }

        return res;
    }
}