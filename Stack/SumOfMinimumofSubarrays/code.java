/*907. Sum of Subarray Minimums
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444 */
package Stack.SumOfMinimumofSubarrays;

import java.util.*;

class Solution {
    public static int[] findnse(int[] arr) {
        int[] nse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    public static int[] findpse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[arr.length];
        for (int i = 0; i <= arr.length - 1; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            pse[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] nse = findnse(arr);
        int[] pse = findpse(arr);
        int total = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            int val = (int) (freq * arr[i] % mod);
            total = (total + val) % mod;
        }
        return total;
    }
}

/*
 * Time Complexity Notes (Monotonic Stack Approach)
 * Overall Complexity: O(n)
 * 1. Key Observation
 * 
 * Even though you see nested while loops, the algorithm is still linear.
 * 
 * Reason: Amortized analysis
 * 
 * 2. Stack Behavior Rule
 * 
 * For both findpse() and findnse():
 * 
 * Each element is:
 * Pushed once onto the stack
 * Popped at most once
 * 
 * So total stack operations:
 * 
 * Push operations ≤ n
 * Pop operations ≤ n
 * 3. Function-wise Breakdown
 * findpse(arr)
 * Loop runs n times
 * Each element pushed once, popped once
 * O(n)
 * findnse(arr)
 * Same logic (reverse traversal)
 * O(n)
 * Final Loop
 * for(int i=0;i<arr.length;i++)
 * 
 * Runs n times → O(n)
 * 
 * 4. Why NOT O(n²)?
 * 
 * At first glance:
 * 
 * for(...) {
 * while(...) {
 * stack.pop();
 * }
 * }
 * 
 * Looks like nested loops → O(n²)
 * 
 * But:
 * 
 * Each element can only be popped once overall, not per iteration
 * Total pops across entire loop = n
 * 5. Final Conclusion
 * findpse → O(n)
 * findnse → O(n)
 * main loop → O(n)
 * 
 * Total → O(n)
 */