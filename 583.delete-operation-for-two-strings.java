/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 */

// @lc code=start
class Solution {
    Integer[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()][word2.length()];
        return dfs(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    public int dfs(String s, int i, String t, int j) {
        if (i == -1 || j == -1) {
            return i == -1 ? j + 1 : i + 1;
        }
        if (memo[i][j] != null)
            return memo[i][j];
        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans = dfs(s, i - 1, t, j - 1);
        } else {
            ans = Math.min(dfs(s, i - 1, t, j), dfs(s, i, t, j - 1)) + 1;
        }
        memo[i][j] = ans;
        return ans;
    }
}
// @lc code=end
