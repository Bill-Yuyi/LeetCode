/*
 * @lc app=leetcode id=1930 lang=java
 *
 * [1930] Unique Length-3 Palindromic Subsequences
 */

// @lc code=start
class Solution {
    public int countPalindromicSubsequence(String s) {
        Integer[] firstSeen = new Integer[26];
        Integer[] lastSeen = new Integer[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstSeen[c - 'a'] == null) {
                firstSeen[c - 'a'] = i;
            } else {
                lastSeen[c - 'a'] = i;
            }
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (firstSeen[i] != null && lastSeen[i] != null) {
                res += s.substring(firstSeen[i] + 1, lastSeen[i]).chars().distinct().count();
            }
        }
        return res;
    }
}
// @lc code=end
