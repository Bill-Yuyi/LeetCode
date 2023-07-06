import java.util.*;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int window = 10, n = s.length();
        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i <= n - 10; i++) {
            if (!set.add(s.substring(i, i + window))) {
                ans.add(s.substring(i, i + window));
            }
        }
        return new ArrayList<>(ans);
    }
}
// @lc code=end
