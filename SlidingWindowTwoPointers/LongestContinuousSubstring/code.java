/*424. Longest Repeating Character Replacement
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too. */
package SlidingWindowTwoPointers.LongestContinuousSubstring;

public class code {

}

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxLen = 0, maxFreq = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            freq[ch - 'A']++;
            maxFreq = (maxFreq < freq[ch - 'A']) ? freq[ch - 'A'] : maxFreq;
            if ((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = (maxLen < r - l + 1) ? r - l + 1 : maxLen;
        }
        return maxLen;
    }
}

/*
 * Complexity Analysis
 * 
 * Time Complexity: O(n), where n is the length of the string,each character is
 * processed at most twice once by the right pointer, once by the left. All
 * operations inside the loop run in constant time.
 * 
 * Space Complexity: O(1), constant space .Only a fixed-size frequency array (26
 * letters) is used, regardless of input size.
 */