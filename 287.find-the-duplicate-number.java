/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int tmp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = tmp;
        }
        return nums[0];
    }
}
// @lc code=end
