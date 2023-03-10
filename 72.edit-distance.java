/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    Integer[][] memo;

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        memo = new Integer[n][m];
        return dfs(word1, n - 1, word2, m - 1);
    }

    public int dfs(String word1, int i, String word2, int j) {
        if (i == -1)
            return j + 1;
        if (j == -1)
            return i + 1;
        if (memo[i][j] != null)
            return memo[i][j];
        int res = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            res = dfs(word1, i - 1, word2, j - 1);
        } else {
            res = Math.min(dfs(word1, i - 1, word2, j) + 1,
                    Math.min(dfs(word1, i - 1, word2, j - 1) + 1, dfs(word1, i, word2, j - 1) + 1));
        }
        memo[i][j] = res;
        return res;
    }
}
// @lc code=end
