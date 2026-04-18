package Heaps;

public class implementMaxHeap {
    static int[] arr;
    static int size;
    static int capacity;

    implementMaxHeap(int n) {
        arr = new int[n + 1];
        arr[0] = -1;
        size = 0;
        capacity = n;
    }

    static int parent(int i) {
        return i / 2;
    }

    static int leftChild(int i) {
        return 2 * i;
    }

    static int rightChild(int i) {
        return 2 * i + 1;
    }

    void insert(int n) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        size++;
        int index = size;
        arr[index] = n;

        while (index > 1) {
            int parent = parent(index);
            if (arr[parent] < arr[index]) {
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            } else {
                return;
            }
        }

    }

    void delete() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }

        arr[1] = arr[size];
        size--;

        /*
         * int i = 1;
         * while (i < size) {
         * int left = 2 * i;
         * int right = 2 * i + 1;
         * int largest = i;
         * if (left <= size && arr[left] > arr[largest]) {
         * largest = left;
         * }if (right <= size && arr[right] > arr[largest]) {
         * largest = right;
         * } else {
         * return;
         * }
         * int temp = arr[i];
         * arr[i] = arr[largest];
         * arr[largest] = temp;
         * i = largest;
         * }
         */
        heapify(arr, size, 1);
    }

    void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left <= n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right <= n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static int getSize() {
        return size;
    }

    static int getMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return arr[1];
    }

    public static void main(String[] args) {
        implementMaxHeap maxHeap = new implementMaxHeap(5);
        maxHeap.insert(50);
        maxHeap.insert(55);
        maxHeap.insert(53);
        maxHeap.insert(52);
        maxHeap.insert(54);
        maxHeap.print();
        maxHeap.delete();
        maxHeap.print();

        int[] arr = { -1, 50, 55, 53, 52, 54 };
        for (int i = (arr.length - 1) / 2; i > 0; i--) {
            maxHeap.heapify(arr, arr.length - 1, i);
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
