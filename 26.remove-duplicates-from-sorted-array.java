/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = i + 1, n = nums.length;
        while (j < n) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                swap(nums, i, j);
                j++;
            }
        }
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
