/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while (i <= k) {
            if (nums[i] == 2) {
                swap(nums, i, k);
                k--;
            } else if (nums[i] == 0) {
                swap(nums, i, j);
                j++;
            }
            i++;
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
