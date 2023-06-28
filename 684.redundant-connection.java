/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        int n = edges.length;
        UF uf = new UF(n + 1);
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }
        return res;
    }
}

class UF {
    int count;
    int[] parent;
    int[] size;

    UF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (size[x] < size[y]) {
                parent[x] = y;
                size[y] += size[x];
            } else {
                parent[y] = x;
                size[x] += size[y];
            }
            count--;
            return false;
        }
        return true;
    }
}
// @lc code=end
