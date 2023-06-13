/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        if (nums[0] != 1) {
            return 1;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i - 1] + 1 != nums[i]) {
                return i + 1;
            }
        }

        return n + 1;

    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
