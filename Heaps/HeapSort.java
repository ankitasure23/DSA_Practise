package Heaps;

public class HeapSort {
    static void heapSort(int[] arr, int n) {
        int temp = arr[0];
        arr[0] = arr[n];
        arr[n] = temp;
        --n;
        heapify(arr, n, 0);
        if (n >= 0) {
            heapSort(arr, n);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

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

    public static void main(String[] args) {
        int[] arr = { 7, 6, 5, 4, 5 };
        int[] input = arr;
        heapSort(arr, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
