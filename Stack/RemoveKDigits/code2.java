
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

public class code2 {

}

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && (stack.peek() - '0') > (num.charAt(i) - '0')) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty())
            return "0";
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }
        res.reverse();
        if (res.length() == 0)
            return "0";
        return res.toString();
    }
}

/*
 * Time Complexity: O(N), since traversing the given string takes O(N) time,
 * each element is pushed onto and popped from the stack at most once in
 * worst-case taking o(N) time, removing the remaining digits (if k > 0) takes
 * O(k) time which can go upto O(N) in worst-case and forming the result,
 * trimming the zeros and reversing the digits takes O(N) time.
 * 
 * Space Complexity: O(N), since we are using a stack to store the digits of the
 * resulting number, in the worst case, the stack can contain all the digits of
 * the input string.
 */
