/*
 * @lc app=leetcode id=1498 lang=java
 *
 * [1498] Number of Subsequences That Satisfy the Given Sum Condition
 */

// @lc code=start
import java.util.*;

class Solution {
    int mod = (int) (1e9 + 7);

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = 2 * pow[i - 1] % mod;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res += pow[right - left];
                res %= mod;
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
// @lc code=end
