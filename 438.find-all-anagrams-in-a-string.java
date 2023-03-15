import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        int distinctChars = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            freqP[c - 'a']++;
            if (freqP[c - 'a'] == 1) {
                distinctChars++;
            }
        }
        int left = 0, valid = 0;
        for (int right = 0; right < s.length(); right++) {
            char in = s.charAt(right);
            freqS[in - 'a']++;
            if (freqS[in - 'a'] == freqP[in - 'a']) {
                valid++;
            }
            while (valid == distinctChars) {
                if (right - left + 1 == p.length()) {
                    ans.add(left);
                }
                char out = s.charAt(left);
                if (freqS[out - 'a'] == freqP[out - 'a']) {
                    valid--;
                }
                freqS[out - 'a']--;
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end
