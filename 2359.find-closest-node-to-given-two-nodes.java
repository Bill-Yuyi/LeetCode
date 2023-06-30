/*
 * @lc app=leetcode id=2359 lang=java
 *
 * [2359] Find Closest Node to Given Two Nodes
 */

// @lc code=start
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        Integer[] dist1 = new Integer[n];
        Integer[] dist2 = new Integer[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        dfs(edges, node1, dist1, 0);
        dfs(edges, node2, dist2, 0);
        int minDist = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1 && minDist > Math.max(dist1[i], dist2[i])) {
                ans = i;
                minDist = Math.max(dist1[i], dist2[i]);
            }
        }

        return ans;
    }

    void dfs(int[] edges, int node, Integer[] dist, int d) {
        if (node != -1 && dist[node] == -1) {
            dist[node] = d;
            dfs(edges, edges[node], dist, d + 1);
        }
    }
}
// @lc code=end
