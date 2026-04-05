/* What is an infix expression?
The traditional way of writing mathematical expressions is called infix expressions, where the operator is placed between two operands (e.g., A + B, (A * B) / Q).
Infix expressions are easy for humans to understand, but computers find them difficult to parse because they require knowledge of operator precedence, associativity rules, and parentheses.
To make it easier for computers, we use postfix and prefix notations.
What is a postfix expression?
A postfix expression has the operator placed after the operands (e.g., PQ-C/). It is written as .
In postfix expressions, the precedence of operators is determined by the order in which they appear in the expression. The operator that appears first is applied to the operands.
Postfix expressions do not require parentheses, making them easier for computers to evaluate.
Approach to Convert Infix Expression to Postfix:
Start by scanning the infix expression from left to right.
If the scanned character is an operand, print it immediately.
If the scanned character is an operator:
If the precedence of the operator is greater than the operator in the stack, or the stack is empty, or the stack contains a ‘(’, push the operator into the stack.
Otherwise, pop all operators from the stack with higher or equal precedence than the scanned operator, then push the scanned operator into the stack.
If the scanned character is a ‘(’, push it into the stack.
If the scanned character is a ‘)’, pop the stack and output the operators until a ‘(’ is encountered, and discard both parentheses.
Repeat steps 2-5 until the entire infix expression has been scanned.
Print the output.
Finally, pop and print all remaining operators in the stack until it is empty. */
package Stack.Conversions;

import java.util.*;

public class InfixToPostFix {

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/' || ch == '%')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }

    public static String infixToPostfix(String exp) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch))
                ans.append(ch);
            else if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    ans.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)";
        System.out.println(infixToPostfix(exp));
    }
}

/*
 * Time Complexity: O(n)
 * Each character is processed once; every element is pushed and popped at most
 * once.
 * Space Complexity: O(n)
 * Stack + output string can store up to n elements.
 */
