/*84. Largest Rectangle in Histogram
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Input: heights = [2,4]
Output: 4 */

package Stack.LargestRectangle;

import java.util.*;

public class code {

}

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

    public int largestRectangleArea(int[] heights) {
        int[] nse = findnse(heights);
        int[] pse = findpse(heights);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (nse[i] - pse[i] - 1));
        }
        return max;
    }
}
