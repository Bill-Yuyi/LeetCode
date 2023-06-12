/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (nums[i] != start) {
                ans.add(start + "->" + nums[i]);
            } else {
                ans.add(String.valueOf(nums[i]));
            }
        }
        return ans;
    }
}
// @lc code=end
