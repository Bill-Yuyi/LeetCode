/*
 * @lc app=leetcode id=2405 lang=java
 *
 * [2405] Optimal Partition of String
 */

// @lc code=start
import java.util.*;

class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int res = 1;
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                res++;
                set.clear();
                set.add(c);
            }
        }
        return res;
    }
}
// @lc code=end
