/*Traverse the postfix expression from left to right.
Use a stack to store operands.
For each operator, pop two operands, combine them with the operator in prefix order, and push the result back.
The final item in the stack will be the prefix expression. */
package Stack.Conversions;

import java.util.*;

public class PostfixToPrefix {
    public static String postfixToPrefix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                StringBuilder ans = new StringBuilder();
                ans.append(ch);
                ans.append(op2);
                ans.append(op1);
                stack.push(ans.toString());
            }
        }
        return stack.pop();
    }

 

  
 *   }
 * 
 * 
 * 
 * /*Time Complexity
 * 
 * Loop
 * 
 * Worst case: O(n²)
 * 
 * Why?
 * 
 * Each step copies
 * 
 * Total work → 1 + 2 + 3 + ... + 
 * 
 
Space Complexity

Stack stores expressions → O(n)
Intermediate strings created → O(n²) total */