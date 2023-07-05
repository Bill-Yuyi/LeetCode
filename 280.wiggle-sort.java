/*
 * @lc app=leetcode id=280 lang=java
 *
 * [280] Wiggle Sort
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 && nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            } else if (i % 2 == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
