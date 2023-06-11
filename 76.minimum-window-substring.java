/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int[] requried = new int[128];
        int requiredChars = 0;
        for (int i = 0; i < t.length(); i++) {
            requried[t.charAt(i)]++;
            if (requried[t.charAt(i)] == 1) {
                requiredChars++;
            }
        }

        int[] mapS = new int[128];
        int[] ans = new int[] { -1, -1, Integer.MAX_VALUE };
        int left = 0, valid = 0;
        for (int right = 0; right < s.length(); right++) {
            char in = s.charAt(right);
            mapS[in]++;
            if (mapS[in] == requried[in]) {
                valid++;
            }
            while (valid == requiredChars) {
                if (right - left + 1 < ans[2]) {
                    ans[0] = left;
                    ans[1] = right;
                    ans[2] = right - left + 1;
                }

                char out = s.charAt(left);
                if (mapS[out] == requried[out]) {
                    valid--;
                }
                mapS[out]--;
                left++;
            }
        }

        return ans[2] == Integer.MAX_VALUE ? "" : s.substring(ans[0], ans[1] + 1);
    }
}
// @lc code=end
