import java.util.Queue;

/*
 * @lc app=leetcode id=2360 lang=java
 *
 * [2360] Longest Cycle in a Graph
 */

// @lc code=start
class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] indegree = new int[n];
        for (int edge : edges) {
            if (edge != -1) {
                indegree[edge]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            if (edges[cur] != -1) {
                indegree[edges[cur]]--;
                if (indegree[edges[cur]] == 0) {
                    queue.offer(edges[cur]);
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int length = 1;
                int neighbor = edges[i];
                visited[i] = true;
                while (neighbor != i) {
                    length++;
                    visited[neighbor] = true;
                    neighbor = edges[neighbor];
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}
// @lc code=end
