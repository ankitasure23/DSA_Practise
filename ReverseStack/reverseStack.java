import java.util.*;

public class reverseStack {

    public static void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insert(stack, temp);
        stack.push(val);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int temp = stack.pop();
        reverse(stack);
        insert(stack, temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println((int) stack.pop());
        }
    }
}
