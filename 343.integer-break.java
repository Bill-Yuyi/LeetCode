/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// @lc code=start
class Solution {
    Integer[] memo;

    public int integerBreak(int n) {
        memo = new Integer[n + 1];
        return dfs(n);
    }

    public int dfs(int remain) {
        if (memo[remain] != null)
            return memo[remain];
        int ans = 1;
        for (int i = 1; i < remain; i++) {
            ans = Math.max(Math.max(dfs(remain - i) * i, ans), (remain - i) * i);
        }
        memo[remain] = ans;
        return ans;
    }
}
// @lc code=end
