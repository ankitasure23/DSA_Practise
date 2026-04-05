/*232. Implement Queue using Stacks
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations. */

package Queue.QueueUsingStacks;

import java.util.*;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public int pop() {
        return s2.pop();
    }

    public int peek() {
        return s2.peek();
    }

    public boolean empty() {
        return s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */