/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = i + 1;
        while (j < nums.length) {
            while (i < j && nums[i] != 0) {
                i++;
            }
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
            j++;
        }
    }
}
// @lc code=end
