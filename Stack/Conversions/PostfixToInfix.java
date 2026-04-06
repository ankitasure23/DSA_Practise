/*Traverse the postfix expression from left to right.
Use a stack to store operands.
For each operator, pop two operands, combine them in infix order with parentheses, and push the result back.
The final item in the stack will be the infix expression. */
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
                StringBuilder temp = new StringBuilder();
                temp.append("(");
                temp.append(op2);
                temp.append(ch);
                temp.append(op1);
                temp.append(")");
                stack.push(temp.toString());
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "AB-DE+F*/";
        System.out.println(postfixToInfix(postfix));
    }
}

/*
 * Time Complexity
 * ✅ Superficial View
 * Single loop over input → O(n)
 * Stack operations → O(1)
 * 
 * 👉 Seems like O(n)
 * 
 * ❗ Actual Hidden Cost
 * 
 * Each time you combine:
 * 
 * (op2 operator op1)
 * You copy entire strings
 * String size keeps increasing
 * 🔥 Worst Case Analysis
 * 
 * Expression like:
 * 
 * AB+C+D+E+F+...
 * 
 * String sizes grow:
 * 
 * 3, 5, 7, 9, ..., n
 * 
 * Total work:
 * 
 * 3 + 5 + 7 + ... + n ≈ O(n²)
 * ✅ Final Time Complexity
 * Case Complexity
 * Best Case O(n)
 * Average Case ~O(n²)
 * Worst Case O(n²)
 * 💾 Space Complexity
 * Stack stores strings → up to O(n)
 * Final expression size → O(n)
 * ✅ Final:
 */