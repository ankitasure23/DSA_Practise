/*503. Next Greater Element II 
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]



Approach 
Initialize an answer array with default values of -1
Initialize an empty stack to keep track of elements
Traverse from 2n - 1 down to 0 using modulus to simulate circular indexing
While stack is not empty and top of stack is less than or equal to current element, pop from stack
If index is in the original array range, assign top of stack to answer if stack is not empty, else keep -1
Push the current element onto the stack
After traversal ends, return the answer array*/

package Stack.MonotonicStack.NextGreaterElement2;

import java.util.*;

public class code2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int ind = i % nums.length;
            while (!stack.isEmpty() && stack.peek() <= nums[ind]) {
                stack.pop();
            }
            if (i < nums.length) {
                nge[i] = (stack.isEmpty()) ? -1 : stack.peek();
            }
            stack.push(nums[ind]);
        }
        return nge;
    }
}

/*
 * Time complexity : O(4N)
 */
