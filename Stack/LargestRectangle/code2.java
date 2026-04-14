/*/*84. Largest Rectangle in Histogram
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Input: heights = [2,4]
Output: 4 */ */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int element = stack.pop();
                int nse = i;
                int pse = (stack.isEmpty())? -1 : stack.peek();
                maxArea = Math.max(heights[element]*(nse-pse-1),maxArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int element = stack.pop();
            int nse = heights.length;
            int pse = (stack.isEmpty())?-1 : stack.peek();
            maxArea = Math.max(maxArea,heights[element]*(nse-pse-1));
        }
        return maxArea;
    }
}