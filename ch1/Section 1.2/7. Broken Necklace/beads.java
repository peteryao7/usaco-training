/*
ID: peterya2
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
    // brute force O(n^2)
    public static void main (String [] args) throws IOException {
        Scanner s = new Scanner(new File("beads.in"));
        PrintWriter out = new PrintWriter(new File("beads.out"));

        int n = s.nextInt();
        String necklace = s.next();
        necklace += necklace; // dupe necklace to check beads as a ring
        char[] c = necklace.toCharArray();
        int max = 0;

        for (int i = 0; i < c.length; i++) {
            int countLeft = 0;
            boolean foundFirstRB = false;
            char curColor = 'w';

            for (int j = i - 1; j >= 0; j--) {
                if (curColor == c[j] || 'w' == c[j]) {
                    countLeft++;
                    if (c[j] != 'w') {
                        foundFirstRB = true;
                        curColor = c[j];
                    }
                }
                else if (c[j] != 'w') {
                    if (!foundFirstRB) {
                        foundFirstRB = true;
                        countLeft++;
                        curColor = c[j];
                    }
                    else {
                        break;
                    }
                }
            }

            int countRight = 0;
            foundFirstRB = false;
            curColor = 'w';

            for (int j = i; j < c.length; j++) {
                if (curColor == c[j] || 'w' == c[j]) {
                    countRight++;
                    if (c[j] != 'w') {
                        foundFirstRB = true;
                        curColor = c[j];
                    }
                }
                else if (c[j] != 'w') {
                    if (!foundFirstRB) {
                        foundFirstRB = true;
                        countRight++;
                        curColor = c[j];
                    }
                    else {
                        break;
                    }
                }
            }

            max = Math.max(max, countLeft + countRight);
            if (max >= n) {
                max = n;
                break;
            }
        }

        out.println(max);
        out.close();
    }
}