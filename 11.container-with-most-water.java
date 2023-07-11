/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] h) {
        int area = 0, n = h.length, res = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            area = Math.min(h[i], h[j]) * (j - i);
            res = Math.max(area, res);
            if (h[i] > h[j]) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
// @lc code=end
