/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
import java.util.*;
// dikijstra

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], val -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { src, 0 });
        int stop = 0;

        while (stop <= k && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int parent = cur[0], distance = cur[1];
                if (graph.containsKey(parent)) {
                    for (int[] next : graph.get(parent)) {
                        int child = next[0], cost = next[1];
                        if (cost + distance > dist[child]) {
                            continue;
                        }
                        dist[child] = cost + distance;
                        queue.offer(new int[] { child, dist[child] });
                    }
                }
            }
            stop++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}
// @lc code=end
