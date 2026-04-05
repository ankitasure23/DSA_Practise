package Stack.Conversions;

import java.util.Stack;

public class PostfixToInfix {
    public static String postfixToInfix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op2 + ch + op1 + ")";
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "AB-DE+F*/";
        System.out.println(postfixToInfix(postfix));
    }
}
