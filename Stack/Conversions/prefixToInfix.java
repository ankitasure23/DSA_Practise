package Stack.Conversions;

import java.util.Stack;

public class prefixToInfix {
    public static String prefixToInfix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                String op1 = stack.pop();
                String op2 = stack.pop();
                StringBuilder temp = new StringBuilder();
                temp.append("(");
                temp.append(op1);
                temp.append(ch);
                temp.append(op2);
                temp.append(")");
                stack.push(temp.toString());
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "*+PQ-MN";
        System.out.println(prefixToInfix(prefix));
    }
}

/*
 * Time complexity : In worst case, each character is processed once, and string
 * operations take linear time, leading to O(n^2) complexity.
 * 
 * The "Snowball" EffectWhile appending a single character is $O(1)$, appending
 * an existing string to a StringBuilder takes $O(k)$ time, where $k$ is the
 * length of the string being appended.Imagine a prefix expression like + + + +
 * A B C D E.First, you combine A and B into (A+B). (Length 5)Then you combine
 * (A+B) and C into ((A+B)+C). (Length 9)Then you combine ((A+B)+C) and D into
 * (((A+B)+C)+D). (Length 13)By the end, you aren't just moving 1 character; you
 * are re-copying the entire "accumulated" string into a new buffer every time
 * you hit an operator.The Math of $O(n^2)$If we represent the work done as the
 * number of character operations:Step 1: Copy ~5 characters.Step 2: Copy ~9
 * characters.Step 3: Copy ~13 characters.Step $N$: Copy ~$(4N + 1)$ characters
 */