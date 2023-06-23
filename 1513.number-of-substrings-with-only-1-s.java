/*
 * @lc app=leetcode id=1513 lang=java
 *
 * [1513] Number of Substrings With Only 1s
 */

// @lc code=start
class Solution {
    int mod = (int) (1e9 + 7);

    public int numSub(String s) {
        int r = 0, res = 0, n = s.length();
        int count = 0;
        while (r < n) {
            count = 0;
            if (s.charAt(r) == '1') {
                count++;
                while (r < n && s.charAt(r) == '1') {
                    r++;
                    count++;
                    res = (res + count - 1) % mod;
                }
            }
            r++;
        }
        return res % mod;
    }
}
// @lc code=end
