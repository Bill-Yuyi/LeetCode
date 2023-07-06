/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 1; i <= n - 1; i++) {
            if (nums[i - 1] > nums[i]) {
                if (count == 1) {
                    return false;
                }
                count++;
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}
// @lc code=end
