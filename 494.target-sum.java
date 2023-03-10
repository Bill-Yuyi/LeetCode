import java.util.HashMap;

/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }

    HashMap<String, Integer> memo = new HashMap<>();

    public int dfs(int[] nums, int remain, int index) {
        if (index == nums.length) {
            if (remain == 0) {
                return 1;
            }
            return 0;
        }
        String key = index + "," + remain;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ans = dfs(nums, remain + nums[index], index + 1) + dfs(nums, remain - nums[index], index + 1);
        memo.put(key, ans);
        return ans;
    }
}
// @lc code=end
