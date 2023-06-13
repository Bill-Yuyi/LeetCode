/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int l_max = 0, r_max = 0;

        int ans = 0;
        while (left < right) {
            l_max = Math.max(height[left], l_max);
            r_max = Math.max(height[right], r_max);
            if (l_max < r_max) {
                ans += l_max - height[left];
                left++;
            } else {
                ans += r_max - height[right];
                right--;
            }
        }
        return ans;
    }
}
// @lc code=end
