/*930. Binary Subarrays With Sum

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 */

package SlidingWindowTwoPointers.BinarySubArraysWithSum;

public class ode {

}

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return function(nums, goal) - function(nums, goal - 1);
    }

    public int function(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int l = 0, r = 0, count = 0, sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}

/*
 * Time Complexity: O(n), where n is the size of the input array.This is because
 * the algorithm uses the sliding window technique twice (in the two calls to
 * atMost). Each `atMost` function runs in linear time , the left and right
 * pointers only move forward, never backward, so the total number of operations
 * is at most 2n.
 * 
 * Space Complexity: O(1), constant extra space.Only a few integer variables are
 * used .
 */