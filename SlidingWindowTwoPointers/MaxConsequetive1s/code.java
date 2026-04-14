/*1004. Max Consecutive Ones III 
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.*/
package SlidingWindowTwoPointers.MaxConsequetive1s;

import java.util.*;

public class code {

}

class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            zero = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0)
                    zero++;
                if (zero <= k) {
                    int len = j - i + 1;
                    max = (max < len) ? len : max;
                } else
                    break;
            }
        }
        return max;
    }
}
