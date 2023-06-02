/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> points = new ArrayList<>();
        for (int[] interval : intervals) {
            points.add(new int[] { interval[0], 1 });
            points.add(new int[] { interval[1], -1 });
        }
        Collections.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int cur = 0, ans = 0;
        for (int[] point : points) {
            cur += point[1];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
// @lc code=end
