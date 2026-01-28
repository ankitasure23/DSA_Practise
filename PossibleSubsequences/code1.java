import java.util.*;

public class PossibleSubsequences {
    public static void printSubsequences(List<String> list, String st, String str, int i) {
        if (i == st.length()) {
            if (str.length() > 0)
                list.add(str);
            return;
        }
        printSubsequences(list, st, str + st.charAt(i), i + 1);
        printSubsequences(list, st, str + "", i + 1);
    }

    public static void main(String[] args) {
        String st = "abc";
        List<String> list = new ArrayList<>();
        printSubsequences(list, st, "", 0);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
