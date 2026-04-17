package Heaps;

public class ConvertArrayToMinHeap {
    public void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left <= n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right <= n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, n, smallest);
        }
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, 5, 1, 4, 3, 10, 2 };
        for (int i = (arr.length - 1) / 2; i > 0; i--) {
            new ConvertArrayToMinHeap().heapify(arr, arr.length - 1, i);
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
