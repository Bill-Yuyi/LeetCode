/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int cur = 0, start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = Math.max(getLen(s, i, i), getLen(s, i, i + 1));
            if (cur > max) {
                max = cur;
                start = i - (cur - 1) / 2;
            }
        }
        return s.substring(start, start + max);
    }

    public int getLen(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return j - i - 1;
    }
}
// @lc code=end
