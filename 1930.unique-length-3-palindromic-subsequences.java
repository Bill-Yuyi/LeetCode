/*
 * @lc app=leetcode id=1930 lang=java
 *
 * [1930] Unique Length-3 Palindromic Subsequences
 */

// @lc code=start
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Integer[] firstSeen = new Integer[26];
        Integer[] lastSeen = new Integer[26];

        for (int i = 0; i < s.length(); i++) {
            if (firstSeen[s.charAt(i) - 'a'] == null) {
                firstSeen[s.charAt(i) - 'a'] = i;
            } else {
                lastSeen[s.charAt(i) - 'a'] = i;
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
