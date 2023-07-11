/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int[] bucket = new int[maxNum + 1];
        for (int num : nums) {
            bucket[num] += num;
        }
        int[] dp = new int[maxNum + 1];
        int res = 0;
        dp[0] = 0;
        dp[1] = bucket[1];
        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 2] + bucket[i], dp[i - 1]);
        }

        return dp[maxNum];
    }
}
// @lc code=end
