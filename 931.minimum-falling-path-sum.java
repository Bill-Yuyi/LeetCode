/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++)
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(
                        j + 1 >= n ? Integer.MAX_VALUE : dp[i - 1][j + 1],
                        Math.min(dp[i - 1][j], j - 1 < 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1])) + matrix[i][j];
            }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
// @lc code=end
