/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0;
        int curEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (curEnd <= interval[0]) {
                curEnd = interval[1];
            } else {
                res++;

            }
        }
        return res;
    }
}
// @lc code=end
