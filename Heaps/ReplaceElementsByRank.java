package Heaps;

import java.util.*;

public class ReplaceElementsByRank {
    public static int[] replaceElements(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i : arr) {
            heap.add(i);
        }
        while (!heap.isEmpty()) {
            int element = heap.poll();
            if (!map.containsKey(element)) {
                map.put(element, rank++);
            }
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 15, 8, 25, 9, 1 };
        int[] result = replaceElements(arr);
        System.out.println(Arrays.toString(result));
    }
}
