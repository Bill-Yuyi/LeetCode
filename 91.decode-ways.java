/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = 1;
            }
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit <= 26 && twoDigit >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[dp.length - 1];

    }
}
// @lc code=end
