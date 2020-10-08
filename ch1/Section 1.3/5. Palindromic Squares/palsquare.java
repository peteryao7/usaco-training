/*
ID: peterya2
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

class palsquare {
    final static char[] digits = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("palsquare.in"));
        PrintWriter out = new PrintWriter(new File("palsquare.out"));

        int base = s.nextInt();

        for (int i = 1; i <= 300; i++) {
            String it = convertBase(i, base);
            String sq = convertBase(i * i, base);
            if (isPalindrome(sq))
                out.println(it + " " + sq);
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