/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    int n, m;
    Integer[][] memo;
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        memo = new Integer[n][m];
        int ans = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, -1));
            }
        return ans;
    }

    int dfs(int[][] matrix, int i, int j, int last) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int max = 1, len = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] <= last) {
                continue;
            }
            len = dfs(matrix, x, y, matrix[i][j]) + 1;
            max = Math.max(len, max);
        }
        return memo[i][j] = max;
    }
}
// @lc code=end
