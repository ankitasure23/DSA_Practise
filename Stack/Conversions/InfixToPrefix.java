/* What is an Infix Expression?
The traditional method of writing mathematical expressions is called infix expressions.
It is written as . The operator is placed between two operands (e.g., A+B or (A*B)/Q).
Infix expressions are easy to understand and evaluate for humans but hard for computers to parse due to operator precedence, associativity rules, and parentheses.
To make parsing easier for computers, we use postfix and prefix notations.
What is a Prefix Expression?
In a prefix expression, the operator is placed before the operands.
The expression is in the form .
Prefix expressions work similarly to postfix expressions. While evaluating, operators are applied immediately to the operands on the right of the operator.
Prefix expressions are also called Polish notation.
Approach to Convert Infix Expression to Prefix:
Reverse the given infix expression.
Scan the expression from left to right.
When an operand is encountered, print it directly.
If the operator is encountered and the stack is empty, push the operator into the stack.
If the incoming operator has higher precedence than the top of the stack, push it into the stack.
If the incoming operator has the same precedence as the top of the stack, push it into the stack.
If the incoming operator has lower precedence than the top of the stack, pop and print the top of the stack. Then, test the incoming operator against the top of the stack again and continue popping operators from the stack until it finds an operator with lower or the same precedence.
If the incoming operator has the same precedence as the top of the stack and the incoming operator is '^', pop the top of the stack until the condition is met. If not, push the '^' operator.
If the operator is ')', push it into the stack.
If the operator is '(', pop all operators from the stack until a ')' is encountered.
If the top of the stack is ')', push the operator onto the stack.
At the end of the expression, pop and print all remaining operators from the stack.
Finally, reverse the output and print it as the prefix expression. */

package Stack.Conversions;

import java.util.*;

public class InfixToPrefix {
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

    public static String infixToPrefix(String exp) {
        StringBuilder input = new StringBuilder(exp);
        input.reverse();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                input.setCharAt(i, ')');
            else if (input.charAt(i) == ')')
                input.setCharAt(i, '(');
        }
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
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
                if (ch == '^') {
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        ans.append(stack.pop());
                    }
                } else {
                    while (!stack.isEmpty() && precedence(ch) < precedence(stack.peek())) {
                        ans.append(stack.pop());
                    }
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String exp = "A^B^C";
        exp = '(' + exp + ')';
        System.out.println(infixToPrefix(exp));
    }
}

/*
 * Time Complexity: O(N), where N is the length of the infix expression. Each
 * character is processed once.
 * 
 * Space Complexity: O(N), where N is the length of the infix expression. The
 * stack can hold at most N characters in the worst case.
 */