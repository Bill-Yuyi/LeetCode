/*
 * @lc app=leetcode id=1984 lang=java
 *
 * [1984] Minimum Difference Between Highest and Lowest of K Scores
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = k - 1, res = Integer.MAX_VALUE;
        while (right < nums.length) {
            res = Math.min(nums[right] - nums[left], res);
            left++;
            right++;
        }
        return res;
    }
}
// @lc code=end
