/*
 * @lc app=leetcode id=1768 lang=java
 *
 * [1768] Merge Strings Alternately
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n || j < m) {
            if (i < n) {
                sb.append(word1.charAt(i++));
            }
            if (j < m) {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }
}
// @lc code=end
