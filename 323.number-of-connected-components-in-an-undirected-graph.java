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
        Set<Integer> set = new HashSet<>();
        for (int i : uf.parent) {
            set.add(uf.find(i));
        }
        return set.size();
    }
}

class UF {
    int[] parent;
    int[] size;

    UF(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
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
                parent[x] = y;
                size[y] += size[y];
            } else {
                parent[y] = x;
                size[x] += size[y];
            }
        }
    }
}
// @lc code=end
