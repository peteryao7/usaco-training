/*
ID: peterya2
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

class dualpal {
    final static char[] digits = new char[]{'0','1','2','3','4','5','6','7','8','9'};
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("dualpal.in"));
        PrintWriter out = new PrintWriter(new File("dualpal.out"));

        int N = s.nextInt();
        int S = s.nextInt();
        
        for (int i = S + 1; N > 0; i++) {
            int ctr = 0;

            for (int base = 2; base <= 10; base++) {
                String it = convertBase(i, base);
                if (isPalindrome(it))
                    ctr++;
            }

            if (ctr >= 2) {
                out.println(i);
                N--;
            }
        }

        out.close();
    }

    private static String convertBase(int num, int base) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(digits[num % base]);
            num /= base;
        }

        return sb.reverse().toString();
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}