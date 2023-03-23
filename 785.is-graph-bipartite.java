/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    boolean isBiGraph = true;
    boolean[] color;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(graph, i);
        }

        return isBiGraph;
    }

    public void dfs(int[][] g, int i) {
        if (!isBiGraph) {
            return;
        }
        visited[i] = true;
        for (int node : g[i]) {
            if (!visited[node]) {
                color[node] = !color[i];
                dfs(g, node);
            } else {
                if (color[node] == color[i]) {
                    isBiGraph = false;
                    return;
                }
            }
        }
    }
}
// @lc code=end
