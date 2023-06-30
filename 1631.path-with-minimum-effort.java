import java.util.*;
/*
 * @lc app=leetcode id=1631 lang=java
 *
 * [1631] Path With Minimum Effort
 */

// @lc code=start
class Solution {
    int row;
    int col;
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumEffortPath(int[][] heights) {
        this.row = heights.length;
        this.col = heights[0].length;
        List<int[]>[] graph = new LinkedList[row * col];
        for (int i = 0; i < row * col; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                int from = calculate(i, j);
                for (int[] dir : dirs) {
                    int ii = i + dir[0], jj = j + dir[1];
                    if (ii < 0 || ii >= row || jj < 0 || jj >= col) {
                        continue;
                    }
                    int to = calculate(ii, jj);
                    graph[from].add(new int[] { to, Math.abs(heights[ii][jj] - heights[i][j]) });
                }
            }
        int[] distTo = dijkstra(graph);
        return distTo[row * col - 1] == Integer.MAX_VALUE ? -1 : distTo[row * col - 1];
    }

    public int[] dijkstra(List<int[]>[] graph) {
        int n = graph.length;
        int[] distTo = new int[n];
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[0] = 0;
        pq.offer(new State(0, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int id = cur.id, dist = cur.dist;
            if (dist > distTo[id]) {
                continue;
            }
            for (int[] next : graph[cur.id]) {
                int to = next[0], d = Math.max(next[1], dist);
                if (d < distTo[to]) {
                    distTo[to] = d;
                    pq.offer(new State(to, d));
                }
            }
        }
        return distTo;
    }

    public int calculate(int i, int j) {
        return i * col + j;
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
