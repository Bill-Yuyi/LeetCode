/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // center can be single char or two chars
            res += count(s, i, i) + count(s, i, i + 1);
        }
        return res;

    }

    // find the center and expand it while counting valid palindromes.
    public int count(String s, int i, int j) {
        int ans = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            ans++;
            i--;
            j++;
        }
        return ans;
    }
}
// @lc code=end
