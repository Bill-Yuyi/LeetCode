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
            int start = trip[1], end = trip[2], val = trip[0];
            diff[start] += val;
            // get off the car at the end point
            diff[end] -= val;
        }
        int[] res = new int[1001];
        res[0] = diff[0];
        for (int i = 1; i <= 1000; i++) {
            res[i] = res[i - 1] + diff[i];
            if (res[i] > capacity) {
                return false;
            }
        }
        return res[0] <= capacity;
    }
}
// @lc code=end
