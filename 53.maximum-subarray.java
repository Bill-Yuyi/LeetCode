/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int first = nums[0];
        int cur;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(first + nums[i], nums[i]);
            first = cur;
            max = Math.max(cur, max);
        }
        return max;
    }
}
// @lc code=end
