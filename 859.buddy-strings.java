/*
 * @lc app=leetcode id=859 lang=java
 *
 * [859] Buddy Strings
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                map[c - 'a']++;
                if (map[c - 'a'] == 2) {
                    return true;
                }
            }
        }

        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        return first != -1 && second != -1 &&
                s.charAt(first) == goal.charAt(second) && goal.charAt(first) == s.charAt(second);
    }
}
// @lc code=end
