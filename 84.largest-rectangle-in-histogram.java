/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0, curHeight = 0, curLength = 0, n = heights.length;
        for (int i = 0; i < n; i++) {
            while (st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                curHeight = heights[st.pop()];
                curLength = i - st.peek() - 1;
                max = Math.max(curHeight * curLength, max);
            }
            st.push(i);
        }

        while (st.peek() != -1) {
            curHeight = heights[st.pop()];
            curLength = n - st.peek() - 1;
            max = Math.max(max, curHeight * curLength);
        }
        return max;
    }
}
// @lc code=end
