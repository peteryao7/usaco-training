/*
ID: peterya2
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        StringTokenizer st2 = new StringTokenizer(f.readLine());

        char[] group = st1.nextToken().toCharArray();
        int groupProd = 1;
        char[] comet = st2.nextToken().toCharArray();
        int cometProd = 1;

        for (char c : group)
            groupProd *= c - 'A' + 1;
        for (char c : comet)
            cometProd *= c - 'A' + 1;
        
        if (groupProd % 47 == cometProd % 47)
            out.println("GO");
        else
            out.println("STAY");

        out.close();
    }
}