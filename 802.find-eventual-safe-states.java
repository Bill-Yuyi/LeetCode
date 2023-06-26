/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdegere = new int[graph.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            for (int next : graph[i]) {
                outdegere[i]++;
                map.computeIfAbsent(next, val -> new ArrayList<>()).add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < outdegere.length; i++) {
            if (outdegere[i] == 0) {
                ans.add(i);
                queue.offer(i);

            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    outdegere[next]--;
                    if (outdegere[next] == 0) {
                        queue.offer(next);
                        ans.add(next);
                    }
                }
            }
        }
        Collections.sort(ans, (a, b) -> (a - b));
        return ans;

    }
}
// @lc code=end
