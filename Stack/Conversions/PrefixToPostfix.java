/*
Traverse the prefix expression from right to left.
Use a stack to store operands.
For each operator, pop two operands from the stack, combine them with the operator, and push the result back.
The final item in the stack will be the postfix expression. */
package Stack.Conversions;

import java.util.*;

public class PrefixToPostfix {
    public static String prefixToPostFix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(op1 + op2 + ch);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "/-AB*+DEF";
        System.out.println(prefixToPostFix(prefix));
    }
}
