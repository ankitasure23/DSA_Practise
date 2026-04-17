/*76. Minimum Window Substring
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string. */
package SlidingWindowTwoPointers.MinimumWindowSubString;

import java.util.*;

public class code {

}

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char i : t.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int l = 0, r = 0, minLength = s.length(), count = 0, start = -1;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (map.getOrDefault(ch, 0) > 0)
                count++;
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            while (count == t.length()) {
                if (minLength >= r - l + 1) {
                    minLength = r - l + 1;
                    start = l;
                }
                char c = s.charAt(l++);
                map.put(c, map.get(c) + 1);
                if (map.get(c) > 0)
                    count--;
            }
            r++;
        }
        return (start == -1) ? "" : s.substring(start, start + minLength);
    }
}

/*
 * Time Complexity : O(m) + O(2n)
 * Space Complexity : O(n)
 */