import java.util.*;
/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i - 1, new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0] - 1).add(new int[] { time[1] - 1, time[2] });
        }
        int[] res = dijkstra(k - 1, graph);
        int ans = -1;
        for (int r : res) {
            ans = Math.max(ans, r);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public int[] dijkstra(int start, HashMap<Integer, List<int[]>> graph) {
        int n = graph.size();
        int[] distTo = new int[n];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist > distTo[cur.id]) {
                continue;
            }
            for (int[] next : graph.get(cur.id)) {
                int to = next[0], d = next[1] + distTo[cur.id];
                if (d < distTo[to]) {
                    distTo[to] = d;
                    pq.offer(new State(to, d));
                }

            }
        }
        return distTo;
    }
}

class State {
    int id;
    int dist;

    State(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}

// @lc code=end
