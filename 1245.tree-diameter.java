/*
 * @lc app=leetcode id=1245 lang=java
 *
 * [1245] Tree Diameter
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

class Solution {
    public int treeDiameter(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int n = edges.length + 1;
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }

        int layer = 0;
        while (n > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
            layer++;
            n -= size;
        }

        if (n == 1) {
            return 2 * layer;
        }

        return layer * 2 + 1;

    }
}
// @lc code=end
