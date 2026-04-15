/*992. Subarrays with K Different Integers
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4]. */
package SlidingWindowTwoPointers.SubArraysWithKDistinctIntegers;

import java.util.*;

public class code {

}

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return function(nums, k) - function(nums, k - 1);
    }

    public int function(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, count = 0;
        if (k < 0)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            if (map.size() <= k)
                count += i - l + 1;
        }
        return count;
    }
}

/*
 * Time Complexity:O(N) ,where n is the length of the array. Both calls to
 * atMostK() are linear.
 * 
 * Space Complexity:O(K) ,where k is the number of distinct elements in the
 * current window. We use a hash map to store frequency counts, which in the
 * worst case could grow to the number of unique elements in the array.
 */