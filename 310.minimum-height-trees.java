/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n <= 1) {
            ans.add(0);
            return ans;
        }

        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            tree.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            tree.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            ans.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                ans.add(cur);
                for (int next : tree.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }

        return ans;
    }
}
// @lc code=end
