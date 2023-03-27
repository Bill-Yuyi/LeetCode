import java.util.*;

/*
 * @lc app=leetcode id=1584 lang=java
 *
 * [1584] Min Cost to Connect All Points
 */

// @lc code=start
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> list = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int x = Math.abs(points[i][0] - points[j][0]), y = Math.abs(points[i][1] - points[j][1]);
                list.add(new int[] { i, j, x + y });
            }
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] p : list) {
            graph.get(p[0]).add(p);
            graph.get(p[1]).add(new int[] { p[1], p[0], p[2] });
        }
        Prim prim = new Prim(graph);
        return prim.allConnected() ? prim.weight : -1;
    }
}

class Prim {
    PriorityQueue<int[]> pq;
    int weight;
    int n;
    boolean[] visited;
    HashMap<Integer, List<int[]>> graph;

    Prim(HashMap<Integer, List<int[]>> graph) {
        this.graph = graph;
        this.n = graph.size();
        visited = new boolean[n];
        weight = 0;
        pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        cut(0);
        visited[0] = true;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int to = current[1];
            if (visited[to]) {
                continue;
            }
            cut(to);
            visited[to] = true;
            weight += current[2];
        }
    }

    void cut(int x) {
        for (int[] neighbor : graph.get(x)) {
            if (visited[neighbor[1]]) {
                continue;
            }
            pq.offer(neighbor);
        }
    }

    boolean allConnected() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}

class UF {
    int count;
    int[] parent;
    int[] size;

    UF(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        count = n;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (size[x] < size[y]) {
                size[y] += size[x];
                parent[x] = y;
            } else {
                size[x] += size[y];
                parent[y] = x;
            }
            count--;
        }
    }

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
// @lc code=end
