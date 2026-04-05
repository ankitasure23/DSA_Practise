/*Problem Statement
496. Next Greater Element I
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 

Approach
To find the next greater element for each element in an array, we can use a stack to efficiently track potential candidates. As we traverse the array from right to left, we maintain a stack that always stores elements in decreasing order from top to bottom. This way, when we process an element, we can simply pop off all smaller or equal elements (which can't be the next greater element), and the top of the stack, if it exists, will be the next greater element. If the stack is empty, there is no greater element to the right, so we assign -1.
Initialize an empty stack and a result array of the same length as input.
Traverse the array from the last element to the first (right to left).
For each element, pop elements from the stack while the stack top is less than or equal to the current element.
If the stack becomes empty, no greater element exists, assign -1 in the result.
Otherwise, the top of the stack is the next greater element for the current element.
Push the current element onto the stack for use in future comparisons.*/
package Stack.MonotonicStack;

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[nums1.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (stack.isEmpty() == false && stack.peek() < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], (stack.isEmpty()) ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
}

/*
 * Time Complexity
 * Each element is pushed once and popped at most once.
 * A single iteration may pop multiple elements, but total pops ≤ n.
 * Total operations = pushes + pops = n + n = O(n).
 * Individual steps can be costly, but amortized work is linear.
 * ✅ Key takeaway: “Each element is processed at most twice → O(n) overall.
 */