package Stack;

public class Stack {
    public int size;
    public int[] arr;
    public int top;

    public Stack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public Stack() {
        this(1000);
    }

    public void push(int num) {
        if (top + 1 == size) {
            System.out.println("Stack is full");
            return;
        }
        arr[++top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(12);
        stack.display();
        System.out.println("Popped element: " + stack.pop());
        stack.display();
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.display();
        stack.pop();
        stack.display();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
