/*3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. */
package SlidingWindowTwoPointers.LongestSubstringwithourrepeatingcharacters;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ind = i - l + 1;
            if (map.get(ch) == null) {
                map.put(ch, i);
                max = (max < ind) ? ind : max;
            } else {
                if (map.get(ch) >= l) {
                    l = map.get(ch) + 1;
                    ind = i - l + 1;
                }
                max = (max < ind) ? ind : max;
                map.put(ch, i);
            }
        }
        return max;
    }
}

public class code {

}

/*
 * Time Complexity: O(n), where n is the length of the string. This is because
 * we are using a single pass through the string with two pointers, leading to
 * linear time complexity.
 * 
 * Space Complexity: O(1), as we are using a fixed-size hash array of size 256
 * (for ASCII characters) and not using any additional data structures that grow
 * with input size.
 */