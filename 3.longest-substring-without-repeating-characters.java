import java.util.HashSet;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            char in = s.charAt(right);
            while (!set.add(in)) {
                char out = s.charAt(left);
                set.remove(out);
                left++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}
// @lc code=end
