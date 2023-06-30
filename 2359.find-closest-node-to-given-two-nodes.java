/*
 * @lc app=leetcode id=2359 lang=java
 *
 * [2359] Find Closest Node to Given Two Nodes
 */

// @lc code=start
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        dfs(edges, node1, dist1, 0);
        dfs(edges, node2, dist2, 0);
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (Math.min(dist1[i], dist2[i]) >= 0 && Math.max(dist1[i], dist2[i]) < min) {
                min = Math.max(dist1[i], dist2[i]);
                ans = i;
            }
        }
        return ans;
    }

    void dfs(int[] edges, int node, int[] dist, int d) {
        if (node != -1 && dist[node] == -1) {
            dist[node] = d;
            dfs(edges, edges[node], dist, d + 1);
        }
    }

}
// @lc code=end
