/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            int val = trip[0], start = trip[1], end = trip[2];
            diff[start] += val;
            diff[end] -= val;
        }
        for (int i = 1; i < 1001; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) {
                return false;
            }
        }
        return diff[0] <= capacity;
    }
}
// @lc code=end
