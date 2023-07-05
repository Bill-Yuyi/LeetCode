/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey(sum) && i - map.get(sum) >= 2) {
                return true;
            } else if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }
        return false;
    }
}
// @lc code=end
