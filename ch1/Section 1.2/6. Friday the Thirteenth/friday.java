/*
ID: peterya2
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
    public static void main (String [] args) throws IOException {
        Scanner s = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new File("friday.out"));
        int N = s.nextInt();
        out.println(getFreqs(N));
        out.close();
    }

    public static String getFreqs(int N) {
        int[] freqs = new int[7];
        int year = 1900;
        int dayOfWeek = 2; // Monday (Sat, Sun, Mon)

        while (year < 1900 + N) {
            int month = 1;

            while (month <= 12) {
                int dayOfMonth = 1;
                int daysInMonth = getDaysInMonth(month, year);

                while (dayOfMonth <= daysInMonth) {
                    if (dayOfMonth == 13)
                        freqs[dayOfWeek]++;

                    dayOfMonth++;
                    dayOfWeek = (dayOfWeek + 1) % 7;
                }

                month++;
            }

            year++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freqs.length; i++) {
            sb.append(freqs[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static int getDaysInMonth(int month, int year) {
        if (month == 2)
            return isLeap(year) ? 29 : 28;
        if (month == 9 || month == 4 || month == 6 || month == 11)
            return 30;
        
        return 31;
    }

    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}