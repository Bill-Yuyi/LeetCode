import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            int curMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    curMax = Math.max(dp[j], curMax);
                }
            }
            dp[i] = curMax + 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

// @lc code=end
