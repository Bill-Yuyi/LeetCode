/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int left = 0, right = needle.length();
        while (right <= haystack.length()) {
            if (haystack.substring(left, right).equals(needle)) {
                return left;
            }
            left++;
            right++;
        }
        return -1;
    }
}
// @lc code=end
