/*
 * @lc app=leetcode id=1376 lang=java
 *
 * [1376] Time Needed to Inform All Employees
 */

// @lc code=start

import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph.computeIfAbsent(manager[i], val -> new ArrayList<>()).add(i);
            }

        }

        int res = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { headID, 0 });
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int id = cur[0], time = cur[1];
            res = Math.max(time, res);
            if (graph.containsKey(id)) {
                for (int next : graph.get(id)) {
                    queue.offer(new int[] { next, time + informTime[id] });
                }
            }
        }
        return res;

    }
}
// @lc code=end
