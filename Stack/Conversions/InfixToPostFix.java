/*
 * What is an infix expression?
 * The traditional way of writing mathematical expressions is called infix
 * expressions, where the operator is placed between two operands (e.g., A + B,
 * (A * B) / Q).
 * Infix expressions are easy for humans to understand, but computers find them
 * difficult to parse because they require knowledge of operator precedence,
 * associativity rules, and parentheses.
 * To make it easier for computers, we use postfix and prefix notations.
 * What is a postfix expression?
 * A postfix expression has the operator placed after the operands (e.g.,
 * PQ-C/). It is written as .
 * In postfix expressions, the precedence of operators is determined by the
 * order in which they appear in the expression. The operator that appears first
 * is applied to the operands.
 * Postfix expressions do not require parentheses, making them easier for
 * computers to evaluate.
 * Approach to Convert Infix Expression to Postfix:
 * Start by scanning the infix expression from left to right.
 * If the scanned character is an operand, print it immediately.
 * If the scanned character is an operator:
 * If the precedence of the operator is greater than the operator in the stack,
 * or the stack is empty, or the stack contains a ‘(’, push the operator into
 * the stack.
 * Otherwise, pop all operators from the stack with higher or equal precedence
 * than the scanned operator, then push the scanned operator into the stack.
 * If the scanned character is a ‘(’, push it into the stack.
 * If the scanned character is a ‘)’, pop the stack and output the operators
 * until a ‘(’ is encountered, and discard both parentheses.
 * Repeat steps 2-5 until the entire infix expression has been scanned.
 * Print the output.
 * Finally, pop and print all remaining operators in the stack until it is
 * empty.
 */
