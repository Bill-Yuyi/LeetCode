/*
 * @lc app=leetcode id=1905 lang=java
 *
 * [1905] Count Sub Islands
 */

// @lc code=start
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length, m = grid1[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                }
            }

        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                    ans++;
                }
            }
        return ans;
    }

    void dfs(int[][] g, int i, int j) {
        if (i < 0 || i >= g.length || j < 0 || g[0].length <= j || g[i][j] == 0) {
            return;
        }
        g[i][j] = 0;
        dfs(g, i - 1, j);
        dfs(g, i + 1, j);
        dfs(g, i, j - 1);
        dfs(g, i, j + 1);
    }
}
// @lc code=end
