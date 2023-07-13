/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int n = edges.length;
        int[] outdegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int edge : edges[i]) {
                outdegree[i]++;
                graph.computeIfAbsent(edge, k -> new ArrayList<>()).add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                queue.offer(i);
                ans.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (graph.containsKey(cur)) {
                    for (int next : graph.get(cur)) {
                        outdegree[next]--;
                        if (outdegree[next] == 0) {
                            queue.offer(next);
                            ans.add(next);
                        }
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
// @lc code=end
