/*
 * @lc app=leetcode id=1177 lang=java
 *
 * [1177] Can Make Palindrome from Substring
 */

// @lc code=start
class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(isP(s, query));
        }
        return ans;
    }

    boolean isP(String s, int[] query) {
        int i = query[0], j = query[1], k = query[2];
        int count = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;
            }
            i++;
            j--;
        }
        return count <= k;
    }
}
// @lc code=end
