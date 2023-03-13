/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        int[] ans = { -1, -1, Integer.MAX_VALUE };
        int left = 0, valid = 0, required = 0;
        int[] freqT = new int[128];
        for (char c : t.toCharArray()) {
            freqT[c]++;
        }
        for (int i = 0; i < 128; i++) {
            if (freqT[i] > 0) {
                required++;
            }
        }
        int[] freqS = new int[128];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqS[c]++;
            if (freqS[c] == freqT[c] && freqT[c] != 0) {
                valid++;
            }
            while (valid == required) {
                if (valid == required) {
                    if (ans[2] > right - left + 1) {
                        ans[2] = right - left + 1;
                        ans[0] = left;
                        ans[1] = right;
                    }
                }
                char out = s.charAt(left);
                if (freqS[out] == freqT[out])
                    valid--;
                freqS[out]--;

                left++;
            }
        }
        return ans[0] == -1 ? "" : s.substring(ans[0], ans[1] + 1);
    }
}
// @lc code=end
