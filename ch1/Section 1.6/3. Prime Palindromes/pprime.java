/*
ID: peterya2
LANG: JAVA
TASK: pprime
*/
import java.io.*;
import java.util.*;

class pprime {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("pprime.in"));
        PrintWriter out = new PrintWriter(new File("pprime.out"));

        int a = s.nextInt();
        int b = s.nextInt();

        if (a % 2 == 0)
            a++;
        
        // all palindromes of even length are divisible by 11
        // so all numbers above 10^7 must be invalid
        // cutting out most of the search space
        b = Math.min(b, 10000000);

        while (a <= b) {
            if (a == reverse(a) && isPrime(a)) {
                out.println(a);
            }

            a += 2;

            // skip all a of even length
            if (a > 11 && a < 100) {
                a = 101;
            }
            if (a > 1000 && a < 10000) {
                a = 10001;
            }
            if (a > 100000 && a < 1000000) {
                a = 1000001;
            }
        }

        out.close();
    }

    private static int reverse(int a) {
        int res = 0;

        while (a > 0) {
            res = res * 10 + a % 10;
            a /= 10;
        }

        return res;
    }

    private static boolean isPrime(int a) {
        if (a < 2 || a % 2 == 0) {
            return a == 2;
        }

        for (int i = 3; i * i <= a; i += 2) {
            if (a % i == 0) {
                return false;
            }
        }

        return true;
    }
}