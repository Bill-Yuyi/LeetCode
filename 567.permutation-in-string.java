/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] freqS1 = new int[26];
        int distinctChars = 0, len = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            freqS1[s1.charAt(i) - 'a']++;
            if (freqS1[s1.charAt(i) - 'a'] == 1) {
                distinctChars++;
            }
        }
        int[] freqS2 = new int[26];
        int left = 0, valid = 0;
        for (int right = 0; right < s2.length(); right++) {
            char in = s2.charAt(right);
            freqS2[in - 'a']++;
            if (freqS2[in - 'a'] == freqS1[in - 'a']) {
                valid++;
            }
            // System.out.println(valid + " " + distinctChars);
            while (right - left + 1 > len) {
                char out = s2.charAt(left);
                if (freqS2[out - 'a'] == freqS1[out - 'a']) {
                    valid--;
                }
                freqS2[out - 'a']--;
                left++;
            }
            if (right - left + 1 == len && valid == distinctChars) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
