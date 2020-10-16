/*
ID: peterya2
LANG: JAVA
TASK: sprime
*/
import java.io.*;
import java.util.*;

class sprime {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("sprime.in"));
        PrintWriter out = new PrintWriter(new File("sprime.out"));

        int n = s.nextInt();
        int[] digits = new int[]{1, 2, 3, 5, 7, 9};

        Queue<Integer> q = new LinkedList<>();
        q.offer(2);
        q.offer(3);
        q.offer(5);
        q.offer(7);

        int i = 1;

        while (i < n) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                int cur = q.poll();
                int temp = cur;

                for (int d : digits) {
                    cur = cur * 10 + d;
                    if (isPrime(cur)) {
                        q.offer(cur);
                    }
                    cur = temp;
                }
            }

            i++;
        }

        while (!q.isEmpty()) {
            out.println(q.poll());
        }

        out.close();
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