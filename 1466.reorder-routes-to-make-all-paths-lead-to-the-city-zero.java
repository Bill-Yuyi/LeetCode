import java.util.*;
/*
 * @lc app=leetcode id=1466 lang=java
 *
 * [1466] Reorder Routes to Make All Paths Lead to the City Zero
 */

// @lc code=start
class Solution {
    public int minReorder(int n, int[][] edges) {
        int res = 0;
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        // build graph
        // since we start from 0, node that directed from 0 should be reverted.
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, val -> new ArrayList<>()).add(new int[] { v, 1 });
            graph.computeIfAbsent(v, val -> new ArrayList<>()).add(new int[] { u, 0 });
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (graph.containsKey(cur)) {
                for (int[] next : graph.get(cur)) {
                    if (!visited[next[0]]) {
                        res += next[1];
                        visited[next[0]] = true;
                        queue.offer(next[0]);
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
