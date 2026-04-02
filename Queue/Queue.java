package Queue;

public class Queue {
    public int size;
    public int[] arr;
    public int front;
    public int rear;

    public Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public Queue() {
        this(1000);
    }

    public void enqueue(int num) {
        if (rear + 1 == size) {
            System.out.println("Queue is full");
            return;
        } else if (front == -1) {
            front = rear = 0;
        } else {
            rear = rear + 1;
        }
        arr[rear] = num;
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
            front++;
        }
        return val;
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }
        return arr[front];
    }

    public int size() {
        if (front == -1) {
            return 0;
        }
        return rear + 1 - front;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        System.out.println(queue.peek());
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();
        queue.enqueue(60);
        System.out.println(queue.pop());
        System.out.println(queue.size());
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.display();
        System.out.println(queue.size());
        queue.enqueue(6);
        queue.display();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(16);
        queue.enqueue(18);
        queue.display();
        queue.pop();
        queue.display();
        queue.enqueue(19);
        queue.display();
    }
}
