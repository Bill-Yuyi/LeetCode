/*
 * @lc app=leetcode id=323 lang=java
 *
 * [323] Number of Connected Components in an Undirected Graph
 */

// @lc code=start
class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }
}

class UF {
    int[] parent;
    int[] size;
    int count;

    UF(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
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
                parent[x] = y;
                size[y] += size[y];
            } else {
                parent[y] = x;
                size[x] += size[y];
            }
            count--;
        }
    }
}
// @lc code=end
