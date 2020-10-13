/*
ID: peterya2
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;

class crypt1 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("crypt1.in"));
        PrintWriter out = new PrintWriter(new File("crypt1.out"));

        int n = s.nextInt();
        Set<Integer> digits = new HashSet<>();

        for (int i = 0; i < n; i++) {
            digits.add(s.nextInt());
        }

        int res = 0;

        for (int i = 100; i <= 999; i++) {
            for (int j = 10; j <= 99; j++) {
                if (isValid(i, digits) && isValid(j, digits) && isValidProd(i, j, digits))
                    res++;
            }
        }

        out.println(res);
        out.close();
    }

    private static boolean isValid(int n, Set<Integer> digits) {
        while (n > 0) {
            if (!digits.contains(n % 10))
                return false;
            n /= 10;
        }

        return true;
    }

    private static boolean isValidProd(int i, int j, Set<Integer> digits) {
        int prod1 = i * (j % 10);
        int prod2 = i * (j / 10);
        int totalProd = i * j;

        if (!isValid(prod1, digits) || !isValid(prod2, digits) || !isValid(totalProd, digits))
            return false;

        if (digitCount(prod1) != 3 || digitCount(prod2) != 3 || digitCount(totalProd) != 4)
            return false;

        return true;
    }

    private static int digitCount(int n) {
        int res = 0;

        while (n > 0) {
            n /= 10;
            res++;
        }

        return res;
    }
}