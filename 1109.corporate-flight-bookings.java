/*
 * @lc app=leetcode id=1109 lang=java
 *
 * [1109] Corporate Flight Bookings
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0] - 1, end = booking[1] - 1, val = booking[2];
            diff[start] += val;
            if (end + 1 < n) {
                diff[end + 1] -= val;
            }
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;

    }
}
// @lc code=end
