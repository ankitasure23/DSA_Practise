package Queue;

public class CircularQueue {
    public static int size;
    public static int[] arr;
    public static int front;
    public static int rear;

    public CircularQueue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public CircularQueue() {
        this(1000);
    }

    public void push(int num) {
        if (front == 0 && rear == size - 1 || (rear + 1) % size == front) {
            System.out.println("Queue overflow");
            return;
        } else if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        arr[rear] = num;
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }
        int val = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return val;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (rear >= front) {
            return rear + 1 - front;
        } else {
            return size - front - rear + 1;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }
        return arr[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        while (true) {
            System.out.println(arr[i]);
            if (i == rear) {
                break;
            }
            i = (i + 1) % size;
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Popped element: " + queue.pop());
        System.out.println("Front element after pop: " + queue.peek());
        queue.push(4);
        queue.push(5);
        System.out.println("Front element after push: " + queue.peek());
        queue.display();
        queue.push(6);
        queue.push(7);
        queue.display();
    }
}
