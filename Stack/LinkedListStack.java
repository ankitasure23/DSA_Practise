package Stack;

import java.util.*;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListStack {
    private Node top;
    int size;

    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int x) {
        Node node = new Node(x);
        node.next = top;
        top = node;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        int poppedValue = top.val;
        top = top.next;
        size--;
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return top.val;
    }

    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek() + " is on top of stack ");
        stack.display();
        System.out.println("Stack size: " + stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop() + " is popped from stack ");
        stack.display();
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.display();
        System.out.println("Stack size: " + stack.size());
    }
}