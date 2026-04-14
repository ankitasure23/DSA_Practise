/*1248. Count Number of Nice Subarrays
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16 */
package SlidingWindowTwoPointers.CountNumberOfNiceSubArrays;

public class code {

}

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return function(nums, k) - function(nums, k - 1);
    }

    public int function(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        if (k < 0)
            return 0;
        while (r < nums.length) {
            if (nums[r] % 2 != 0)
                k--;
            while (k < 0) {
                if (nums[l] % 2 != 0)
                    k++;
                ;
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}

/*
 * Time Complexity:O(n) ,We scan the array two times using the sliding window
 * helper. Each scan processes every element at most once, making it linear in
 * size of input.
 * 
 * Space Complexity:O(1) ,No additional space is used except a few integer
 * variables for tracking window bounds and counts. So, constant space.
 */