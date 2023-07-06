/*
 * @lc app=leetcode id=838 lang=java
 *
 * [838] Push Dominoes
 */

// @lc code=start
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];
        int force = 0;
        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if (c == 'R') {
                force = n;
            } else if (c == 'L') {
                force = 0;
            } else {
                force = Math.max(0, force - 1);
            }
            forces[i] += force;
        }

        for (int j = n - 1; j >= 0; j--) {
            char c = dominoes.charAt(j);
            if (c == 'L') {
                force = n;
            } else if (c == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[j] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int f : forces) {
            sb.append(f < 0 ? 'L' : f > 0 ? 'R' : '.');
        }
        return sb.toString();
    }
}
// @lc code=end
