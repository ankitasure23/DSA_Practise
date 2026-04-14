/*402. Remove K Digits
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0. */
package Stack.RemoveKDigits;

import java.util.*;

public class code {

}

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = num.length();
        int ind = 0;
        int size = n - k;
        int want = size - ind;
        for (int i = 0; i < n; i++) {
            int number = num.charAt(i) - '0';
            int left = n - i;
            while (!stack.isEmpty() && left > want && stack.peek() > number) {
                stack.pop();
                ind--;
                want = size - ind;
            }
            stack.push(number);
            ind++;
            want = size - ind;
        }
        while (!stack.isEmpty() && ind > size) {
            stack.pop();
            ind--;
        }
        String st = "";
        while (!stack.isEmpty()) {
            char ch = (char) (stack.pop() + '0');
            st = ch + st;
        }
        while (st != "" && st.charAt(0) == '0')
            st = st.substring(1);
        return (st.length() == 0) ? "0" : st;
    }
}
