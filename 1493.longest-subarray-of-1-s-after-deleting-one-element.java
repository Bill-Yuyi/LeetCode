/*
 * @lc app=leetcode id=1493 lang=java
 *
 * [1493] Longest Subarray of 1's After Deleting One Element
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0, ones = 0, zeros = 0;
        int left = 0;
        boolean flag = false;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                ones++;
            } else {
                flag = true;
                zeros++;
            }
            while (left < right && zeros > 1) {
                if (nums[left] == 1) {
                    ones--;
                } else {
                    zeros--;
                }
                left++;
            }
            res = Math.max(ones, res);
        }
        return flag ? res : res - 1;
    }
}
// @lc code=end
