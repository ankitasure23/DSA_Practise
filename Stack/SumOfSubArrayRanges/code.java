/*2104. Sum of Subarray Ranges
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59. */
package Stack.SumOfSubArrayRanges;

public class code {

}

class Solution {
    public static int[] findNse(int[] arr) {
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

    public static int[] findPse(int[] arr) {
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

    public static int[] findNge(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }

    public static int[] findPge(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }

    public long subarrayMinimum(int[] nums) {
        int[] nse = findNse(nums);
        int[] pse = findPse(nums);
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            long val = freq * nums[i];
            total += val;
        }
        return total;
    }

    public long subarrayMaximum(int[] nums) {
        int[] nge = findNge(nums);
        int[] pge = findPge(nums);
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;
            long freq = left * right * 1L;
            long val = freq * nums[i];
            total = total + val;
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        long max = subarrayMaximum(nums);
        long min = subarrayMinimum(nums);
        return max - min;
    }
}

/*
 * Time complexity O(n)
 * Space Complexity : O(n)
 */
