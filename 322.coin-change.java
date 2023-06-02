/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(1 + dp[i - c], dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
// @lc code=end
