/*
 * @lc app=leetcode id=1461 lang=java
 *
 * [1461] Check If a String Contains All Binary Codes of Size K
 */

// @lc code=start
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int res = (int) Math.pow(2, k);
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));

        }
        return set.size() == res;
    }
}
// @lc code=end
