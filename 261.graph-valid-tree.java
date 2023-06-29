/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                return false;
            }
        }
        return uf.count == 1;
    }

}

class UF {
    int count;
    int[] parent;
    int[] size;

    UF(int n) {
        count = n;
        size = new int[n];
        parent = new int[n];
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
                size[y] += size[x];
                parent[x] = y;
            } else {
                size[x] += size[y];
                parent[y] = x;
            }
            count--;
            return false;
        }
        return true;
    }
}
// @lc code=end
