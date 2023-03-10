/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    Integer[][] memo;

    public int numDistinct(String s, String t) {
        memo = new Integer[s.length()][t.length()];
        return dfs(s, 0, t, 0);
    }

    public int dfs(String s, int i, String t, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (s.length() - i < t.length() - j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(s, i + 1, t, j + 1) + dfs(s, i + 1, t, j);
        } else {
            res += dfs(s, i + 1, t, j);
        }
        memo[i][j] = res;
        return res;
    }
}
// @lc code=end
