/*
ID: peterya2
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;

class Gap implements Comparable<Gap> {
    int start;
    int end;

    public Gap(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // sort based on ascending size of gaps
    public int compareTo(Gap o) {
        return size() - o.size();
    }

    public int size() {
        // exclude start and end stalls
        return end - start - 1;
    }
}

class barn1 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("barn1.in"));
        PrintWriter out = new PrintWriter(new File("barn1.out"));

        // M = maximum number of boards that can be purchased
        // S = total number of stalls
        // C = number of cows in the stalls
        int M = s.nextInt();
        int S = s.nextInt();
        int C = s.nextInt();

        int[] stalls = new int[C];

        for (int i = 0; i < stalls.length; i++) {
            stalls[i] = s.nextInt();
        }

        Arrays.sort(stalls);
        
        LinkedList<Gap> gaps = new LinkedList<>();

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[i - 1] > 1)
                gaps.add(new Gap(stalls[i - 1], stalls[i]));
        }

        Collections.sort(gaps);

        int boards = gaps.size() + 1;
        int stallsCovered = C;
        
        while (boards > M) {
            Gap g = gaps.remove();
            stallsCovered += g.size();
            boards--;
        }

        out.println(stallsCovered);
        out.close();
    }
}