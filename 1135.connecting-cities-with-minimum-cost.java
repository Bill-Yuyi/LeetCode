import java.util.*;

/*
 * @lc app=leetcode id=1135 lang=java
 *
 * [1135] Connecting Cities With Minimum Cost
 */

// @lc code=start
class Solution {
    public int minimumCost(int n, int[][] connections) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] con : connections) {
            graph.get(con[0] - 1).add(new int[] { con[0] - 1, con[1] - 1, con[2] });
            graph.get(con[1] - 1).add(new int[] { con[1] - 1, con[0] - 1, con[2] });
        }
        Prim prim = new Prim(graph);
        return prim.allConnected() ? prim.weight : -1;
    }
}

class Prim {
    PriorityQueue<int[]> pq;
    int weight;
    boolean[] visited;
    HashMap<Integer, List<int[]>> graph;

    Prim(HashMap<Integer, List<int[]>> graph) {
        this.graph = graph;
        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        visited = new boolean[graph.size()];
        weight = 0;
        visited[0] = true;
        cut(0);
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[1]]) {
                continue;
            }
            weight += cur[2];
            visited[cur[1]] = true;
            cut(cur[1]);
        }
    }

    void cut(int x) {
        if (graph.containsKey(x)) {
            for (int[] neighbor : graph.get(x)) {
                if (visited[neighbor[1]]) {
                    continue;
                }
                pq.offer(neighbor);
            }
        }
    }

    boolean allConnected() {
        for (int i = 0; i < graph.size(); i++) {
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
