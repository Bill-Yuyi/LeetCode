import java.util.*;
/*
 * @lc app=leetcode id=1514 lang=java
 *
 * [1514] Path with Maximum Probability
 */

// @lc code=start
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            // i is index of prob
            graph[from].add(new int[] { to, i });
            graph[to].add(new int[] { from, i });
        }
        double[] distTo = dijkstra(start, graph, succProb);
        return distTo[end] == -1 ? 0.0 : distTo[end];

    }

    public double[] dijkstra(int start, List<int[]>[] graph, double[] succProb) {
        int n = graph.length;
        double[] distTo = new double[n];
        Arrays.fill(distTo, -1);
        distTo[start] = 1.0;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.prob, a.prob);
        });
        pq.offer(new State(start, 1.0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int id = cur.id;
            double prob = cur.prob;
            if (prob < distTo[id]) {
                continue;
            }
            for (int[] next : graph[id]) {
                int to = next[0], index = next[1];
                double p = prob * succProb[index];
                if (p > distTo[to]) {
                    distTo[to] = p;
                    pq.offer(new State(to, p));
                }
            }

        }
        return distTo;
    }
}

class State {
    int id;
    double prob;

    State(int id, double prob) {
        this.id = id;
        this.prob = prob;
    }
}
// @lc code=end
