/*
 * @lc app=leetcode id=2348 lang=java
 *
 * [2348] Number of Zero-Filled Subarrays
 */

// @lc code=start
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int i = 0, n = nums.length;
        while (i < n) {
            while (i < n && nums[i] != 0) {
                i++;
            }
            int tmp = i;
            while (i < n && nums[i] == 0) {
                i++;
            }
            int len = i - tmp;
            res += (len + 1) * (len / 2.0);

        }
        return res;
    }
}
// @lc code=end
