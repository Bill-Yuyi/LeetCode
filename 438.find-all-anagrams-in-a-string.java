import java.util.ArrayList;
import java.util.Arrays;
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
        int n = s.length(), m = p.length();
        if (n < m) {
            return ans;
        }

        int[] freqS = new int[26], freqT = new int[26];
        freqT = build(freqT, p);
        freqS = build(freqS, s.substring(0, m));
        if (Arrays.equals(freqS, freqT)) {
            ans.add(0);
        }
        freqS[s.charAt(0) - 'a']--;
        int left = 1;
        for (int right = m; right < n; right++) {
            char c = s.charAt(right);
            freqS[c - 'a']++;
            if (Arrays.equals(freqS, freqT)) {
                ans.add(left);
            }
            freqS[s.charAt(left++) - 'a']--;
        }
        return ans;

    }

    int[] build(int[] freq, String s) {
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

}
// @lc code=end
