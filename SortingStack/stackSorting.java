
import java.util.*;

public class stackSorting {

    public static void insert(Stack<Integer> s, int temp) {
        if (s.isEmpty() || s.peek() <= temp) {
            s.push(temp);
            return;
        }
        int val = s.pop();
        insert(s, temp);
        s.push(val);
    }

    public static void sorting(Stack s) {
        if (!s.isEmpty()) {
            int temp = (int) s.pop();
            sorting(s);
            insert(s, temp);
        }
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(78);
        stack.push(49);
        stack.push(18);
        stack.push(85);
        stack.push(100);
        stack.push(1);
        stack.push(5);
        stack.push(10);
        stack.push(4);
        stack.push(9);
        sorting(stack);
        while (!stack.isEmpty()) {
            System.out.println((int) stack.pop());
        }
    }
}
