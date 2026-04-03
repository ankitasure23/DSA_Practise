package Queue;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListQueue {
    private Node front;
    private int size;
    private Node rear;

    public LinkedListQueue() {
        this.front = null;
        this.size = 0;
        this.rear = null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(int x) {
        Node node = new Node(x);
        if (isEmpty()) {
            this.front = this.rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        this.size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return;
        }
        System.out.println("Dequeued element: " + front.val);
        front = front.next;
        this.size--;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return;
        }
        System.out.println("Front element: " + front.val);
    }

    public void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.peek();
        queue.dequeue();
        queue.peek();
        System.out.println("Queue size: " + queue.size());
        queue.display();
    }
}
