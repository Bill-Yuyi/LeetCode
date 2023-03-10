/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int start = 0, cur = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = Math.max(getLen(s, i, i), getLen(s, i, i + 1));
            if (maxLen < cur) {
                maxLen = cur;
                start = i - (cur - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public int getLen(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }
}
// @lc code=end
