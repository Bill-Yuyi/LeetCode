import java.util.Arrays;

/*
 * @lc app=leetcode id=2492 lang=java
 *
 * [2492] Minimum Score of a Path Between Two Cities
 */

// @lc code=start
class Solution {
    public int minScore(int n, int[][] roads) {
        UF uf = new UF(n);
        for (int[] road : roads) {
            uf.union(road[1], road[0]);
        }
        int res = Integer.MAX_VALUE;
        for (int[] road : roads) {
            if (uf.find(road[0]) == uf.find(n) || uf.find(road[1]) == uf.find(n)) {
                res = Math.min(res, road[2]);
            }
        }
        return res;
    }
}

class UF {
    int[] parent;

    UF(int n) {
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
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
            parent[y] = x;
        }
    }
}
// @lc code=end
