/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            area = Math.max(Math.min(height[left], height[right]) * (right - left), area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
// @lc code=end
