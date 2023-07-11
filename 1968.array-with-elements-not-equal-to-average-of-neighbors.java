/*
 * @lc app=leetcode id=1968 lang=java
 *
 * [1968] Array With Elements Not Equal to Average of Neighbors
 */

// @lc code=start
// nums[0] > nums[1] < nums[2]
class Solution {
    public int[] rearrangeArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] < nums[i - 1] || i % 2 == 1 && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
