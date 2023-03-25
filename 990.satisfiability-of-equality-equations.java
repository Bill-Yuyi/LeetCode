/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                uf.union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                if (uf.connected(str.charAt(0) - 'a', str.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
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

    boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
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
