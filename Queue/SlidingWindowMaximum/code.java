/*239. Sliding Window Maximum
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1] */
package Queue.SlidingWindowMaximum;

import java.util.*;

public class code {

}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!d.isEmpty() && d.peekFirst() <= i - k)
                d.pollFirst();
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.pollFirst();
            }
            d.addLast(i);
            if (i >= k - 1)
                list.add(nums[d.peekFirst()]);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}

/*
 * Time Complexity: O(n) Each element is pushed and popped from the deque at
 * most once, so overall traversal is linear.
 * 
 * Space Complexity: O(k) Deque stores at most k elements at any time, one for
 * each index in the window.
 */