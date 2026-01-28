//using backtracking and stringbuilder
import java.util.*;

public class PossibleSubsequences {

    public static void printSubs(String st, StringBuilder str, int i) {
        if (i == st.length()) {
            if (str.length() > 0)
                System.out.println(str.toString());
            return;
        }
        str.append(st.charAt(i));
        printSubs(st, str, i + 1);
        // backtracking
        str.deleteCharAt(str.length() - 1);
        printSubs(st, str, i + 1);
    }

    public static void main(String[] args) {
        String st = "abc";

        printSubs(st, new StringBuilder(), 0);
    }
}
