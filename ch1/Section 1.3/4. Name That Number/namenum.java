/*
ID: peterya2
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

class namenum {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("namenum.in"));
        PrintWriter out = new PrintWriter(new File("namenum.out"));
        Scanner sdict = new Scanner(new File("dict.txt"));

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PRS");
        map.put(8, "TUV");
        map.put(9, "WXY");

        char[] digits = s.next().toCharArray();
        List<String> res = new ArrayList<>();
        String name;

        while (sdict.hasNext()) {
            name = sdict.next();
            boolean same = true;

            if (digits.length == name.length()) {
                for (int i = 0; i < digits.length; i++) {
                    String letters = map.get(digits[i] - '0');
                    if (letters.indexOf(name.charAt(i)) == -1) {
                        same = false;
                        break;
                    }
                }

                if (same)
                    res.add(name);
            }
        }

        if (res.size() > 0) {
            for (String r : res)
                out.println(r);
        }
        else {
            out.println("NONE");
        }

        out.close();
    }
}