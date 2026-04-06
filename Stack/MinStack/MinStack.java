package Stack.MinStack;

import java.util.*;

class MinStack {
    Stack<Long> stack = new Stack<>();
    private long min;

    public MinStack() {

    }

    public void push(int val) {
        long v = val;
        if (stack.isEmpty()) {
            min = v;
            stack.push(v);
            return;
        } else if (v > min)
            stack.push(v);
        else {
            stack.push(2 * v - min);
            min = v;
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        long x = stack.pop();
        if (x < min) {
            min = 2 * min - x;
        }
    }

    public int top() {
        long x = stack.peek();
        return (int) ((x > min) ? x : min);
    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */