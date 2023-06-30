/*
 * @lc app=leetcode id=1129 lang=java
 *
 * [1129] Shortest Path with Alternating Colors
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < redEdges.length; i++) {
            int u = redEdges[i][0], v = redEdges[i][1];
            graph.computeIfAbsent(u, val -> new ArrayList<>()).add(new int[] { v, 0 });
        }

        for (int[] edge : blueEdges) {
            graph.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(new int[] { edge[1], 1 });
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[0] = 0;

        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true;
        visited[0][1] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, -1 });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], step = cur[1], color = cur[2];
            if (!graph.containsKey(node)) {
                continue;
            }
            for (int[] next : graph.get(node)) {
                int nextNode = next[0], nextColor = next[1];
                if (!visited[nextNode][nextColor] && nextColor != color) {
                    if (res[nextNode] == -1) {
                        res[nextNode] = step + 1;
                    }
                    queue.offer(new int[] { nextNode, step + 1, nextColor });
                    visited[nextNode][nextColor] = true;
                }
            }

        }
        return res;
    }
}
// @lc code=end
