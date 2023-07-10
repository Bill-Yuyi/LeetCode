/*
 * @lc app=leetcode id=370 lang=java
 *
 * [370] Range Addition
 */

// @lc code=start
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for (int[] update : updates) {
            int start = update[0], end = update[1] + 1, val = update[2];
            diff[start] += val;
            if (end < length) {
                diff[end] -= val;
            }
        }
        for (int i = 1; i < length; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}
// @lc code=end
