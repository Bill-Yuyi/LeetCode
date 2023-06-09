/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int j = 0, k = 0, diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(diff)) {
                    diff = sum - target;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return diff + target;
    }
}
// @lc code=end
