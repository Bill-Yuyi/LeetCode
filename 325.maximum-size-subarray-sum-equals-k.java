/*
 * @lc app=leetcode id=325 lang=java
 *
 * [325] Maximum Size Subarray Sum Equals k
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, length = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - k)) {
                length = Math.max(i - map.get(sum - k), length);
            }
        }
        return length;
    }
}
// @lc code=end
