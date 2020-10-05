/*
ID: peterya2
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
    public static void main (String [] args) throws IOException {
        Scanner s = new Scanner(new File("gift1.in"));
        PrintWriter out = new PrintWriter(new File("gift1.out"));

        int NP = s.nextInt();
        List<String> allPpl = new ArrayList<>();

        for (int i = 0; i < NP; i++) {
            allPpl.add(s.next());
        }

        Map<String, Integer> start = new HashMap<>();
        Map<String, Integer> received = new HashMap<>();

        for (int i = 0; i < NP; i++) {
            String person = s.next();
            int giftTotal = s.nextInt();
            int ppl = s.nextInt();

            start.put(person, -giftTotal);
            int gift = 0;

            if (ppl > 0) {
                gift = giftTotal / ppl;
                received.put(person, received.getOrDefault(person, 0) + (giftTotal % ppl));
            }
            else {
                received.put(person, received.getOrDefault(person, 0) + giftTotal);
            }

            for (int j = 0; j < ppl; j++) {
                String recipient = s.next();
                received.put(recipient, received.getOrDefault(recipient, 0) + gift);
            }
        }

        for (String person : allPpl) {
            out.println(person + " " + (received.get(person) + start.get(person)));
        }

        out.close();
    }
}