/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_0 = 0, dp_1 = -prices[0], dp_pre = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, dp_pre - prices[i]);
            dp_pre = tmp;
        }
        return dp_0;
    }
}
// @lc code=end
