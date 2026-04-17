/*Check if an array represents a min heap
Problem Statement: Given an array of integers nums. Check whether the array represents a binary min-heap or not. Return true if it does, otherwise return false.
A binary min-heap is a complete binary tree where the key at the root is the minimum among all keys present in a binary min-heap and the same property is recursively true for all nodes in a Binary Tree. */

package Heaps;

public class ArrayRepresentsMinHeap {
    public static boolean isMinHeap(int[] arr, int n) {
        for (int i = 0; i <= n / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if ((left <= n && right <= n) && (arr[i] > arr[left] || arr[i] > arr[right])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int[] arr = { 3, 2, 2, 3, 4, 5, 10 };
        int n = arr.length;
        if (isMinHeap(arr, n - 1)) {
            System.out.println("The array represents a min heap");
        } else {
            System.out.println("The array does not represent a min heap");
        }

        int[] arr1 = { 1, 2, 2, 3, 4, 5, 10 };
        int n1 = arr.length - 1;
        if (isMinHeap(arr1, n1 - 1)) {
            System.out.println("The array represents a min heap");
        } else {
            System.out.println("The array does not represent a min heap");
        }
    }
}

/*
 * Time Complexity: O(n), where n is the number of elements in the array. We
 * only iterate through the non-leaf nodes, which are at most n/2, so it's still
 * O(n) in terms of asymptotic complexity. Each comparison (at most two per
 * node) is constant time.
 * 
 * Space Complexity: O(1), no extra space is used. We only use a few variables.
 */