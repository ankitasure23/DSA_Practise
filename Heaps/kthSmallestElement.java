package Heaps;

import java.util.*;

public class kthSmallestElement {
    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i <= nums.length - 1; i++) {
            heap.add(nums[i]);
            if (heap.size() > k)
                heap.poll();
        }
        // System.out.print(heap);
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 4 };
        int k = 3;
        kthSmallestElement obj = new kthSmallestElement();
        System.out.println(obj.findKthSmallest(nums, k));
    }
}
