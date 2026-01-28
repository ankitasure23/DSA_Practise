//using bit manipulation 
// 1 << n gives the binary of the 2^n that is the number of subsequences to be generated .
import java.util.*;

public class printSubsUsingBit {
    public static void main(String[] args) {
        String st = "abca";
        int n = st.length();
        for (int num = 0; num < (1 << n); num++) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    str.append(st.charAt(i));
                }
            }
            System.out.println(str.toString());
        }
    }
}
