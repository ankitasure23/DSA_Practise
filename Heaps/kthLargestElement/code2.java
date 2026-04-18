package Heaps.kthLargestElement;

import java.util.*;

public class code2 {

}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        // System.out.print(heap);
        return heap.peek();
    }
}

/*
 * Time Complexity: O(N * log K), where N is the size of the given input array.
 * Traversing the array takes O(N) time, and for each element, in the worst
 * case, we perform heap operations which take O(log K) time. Note that K can be
 * equal to N in the worst case, making the worst-case time complexity as O(N *
 * log N).
 * 
 * Space Complexity: O(K), as a Min-heap data structure of size K is used to
 * store the K largest elements.
 */
