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
            int start = booking[0] - 1, end = booking[1], val = booking[2];
            diff[start] += val;
            if (end < n) {
                diff[end] -= val;
            }
        }
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;

    }
}
// @lc code=end
