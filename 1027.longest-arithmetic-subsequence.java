/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Subsequence
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        HashMap<Integer, Integer>[] map = new HashMap[nums.length];
        int n = nums.length;

        int max = 0;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                diff = nums[i] - nums[j];
                map[i].put(diff, map[j].getOrDefault(diff, 1) + 1);
                max = Math.max(max, map[i].get(diff));
            }
        }
        return max;
    }

}
// @lc code=end
