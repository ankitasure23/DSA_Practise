/*1358. Number of Substrings Containing All Three Characters
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1 */

public class code {

}

class Solution {
    public int numberOfSubstrings(String s) {
        int[] ls = new int[] { -1, -1, -1 };
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ls[ch - 'a'] = i;
            count += 1 + ((int) (Math.min(Math.min(ls[0], ls[1]), ls[2])));
        }
        return count;
    }
}

/*
 * Time Complexity:O(n) ,We traverse the string once with the right pointer and
 * adjust the left pointer in a linear pass. Each character is processed at most
 * twice (once by the right pointer and once by the left), resulting in linear
 * time complexity.
 * 
 * Space Complexity: O(1),We only use a constant-size frequency array for three
 * characters ('a', 'b', 'c'), hence the space usage does not grow with input
 * size.
 */