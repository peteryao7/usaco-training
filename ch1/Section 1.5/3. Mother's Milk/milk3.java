/*
ID: peterya2
LANG: JAVA
TASK: milk3
*/
import java.io.*;
import java.util.*;

class milk3 {
    static int[] capacities;
    static boolean[] res;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("milk3.in"));
        PrintWriter out = new PrintWriter(new File("milk3.out"));

        // [A, B, C]
        capacities = new int[]{s.nextInt(), s.nextInt(), s.nextInt()};
        // current state of milk
        int[] milk = new int[]{0, 0, capacities[2]};
        res = new boolean[capacities[2] + 1];
        visited = new boolean[capacities[0] + 1][capacities[1] + 1][capacities[2] + 1];

        getAllStates(milk);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i]) {
                sb.append(i);
                sb.append(' ');
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        out.println(sb);
        out.close();
    }

    private static void getAllStates(int[] milk) {
        if (visited[milk[0]][milk[1]][milk[2]]) {
            return;
        }

        visited[milk[0]][milk[1]][milk[2]] = true;

        // result step - no milk in A
        if (milk[0] == 0) {
            res[milk[2]] = true;
        }

        // try all possible pours with DFS
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    // pour i into j
                    getAllStates(pourMilk(milk, i, j));
                }
            }
        }
    }

    private static int[] pourMilk(int[] milk, int i, int j) {
        // deep copy - don't modify the state of milk here for recursive calls
        int[] cur = milk.clone();

        if (cur[i] + cur[j] <= capacities[j]) {
            cur[j] += cur[i];
            cur[i] = 0;
        }
        else {
            cur[i] = cur[i] - capacities[j] + cur[j];
            cur[j] = capacities[j];
        }

        return cur;
    }
}