/*
 * @lc app=leetcode id=1443 lang=java
 *
 * [1443] Minimum Time to Collect All Apples in a Tree
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        return dfs(0, graph, hasApple, new boolean[n]);

    }

    int dfs(int node, HashMap<Integer, List<Integer>> graph, List<Boolean> hasApples, boolean[] visited) {
        if (visited[node]) {
            return 0;
        }
        visited[node] = true;
        int res = 0;
        if (graph.containsKey(node)) {
            for (int next : graph.get(node)) {
                res += dfs(next, graph, hasApples, visited);
            }
        }
        if (node > 0 && (res > 0 || hasApples.get(node)))
            res += 2;
        return res;
    }
}
// @lc code=end
