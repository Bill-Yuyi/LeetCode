/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], tmp * nums[i]), nums[i]);
            curMax = Math.max(max, curMax);
        }
        return curMax;
    }
}
// @lc code=end
