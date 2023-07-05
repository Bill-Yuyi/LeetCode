/*
 * @lc app=leetcode id=815 lang=java
 *
 * [815] Bus Routes
 */

// @lc code=start
import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j : routes[i]) {
                graph.computeIfAbsent(j, val -> new HashSet<>()).add(i);
            }
        }

        Set<Integer> seen = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { source, 0 });
        seen.add(source);
        boolean[] visitedRoutes = new boolean[n];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], step = cur[1];
            if (node == target) {
                return step;
            }

            if (graph.containsKey(node)) {
                for (int next : graph.get(node)) {
                    if (visitedRoutes[next]) {
                        continue;
                    }
                    for (int j : routes[next]) {
                        if (!seen.contains(j)) {
                            seen.add(j);
                            queue.offer(new int[] { j, step + 1 });
                        }
                    }
                    visitedRoutes[next] = true;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
