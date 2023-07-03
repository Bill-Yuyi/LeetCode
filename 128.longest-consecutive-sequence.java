/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0, cur = 0, count = 0;

        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            cur = num;
            count = 0;
            while (set.contains(cur)) {
                count++;
                cur++;
            }
            max = Math.max(max, count);
        }

        return max;

    }
}
// @lc code=end
