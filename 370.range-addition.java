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
            int start = update[0], end = update[1], val = update[2];
            diff[start] += val;
            if (end + 1 < length) {
                diff[end + 1] -= val;
            }
        }
        int[] res = new int[length];
        res[0] = diff[0];
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
// @lc code=end
