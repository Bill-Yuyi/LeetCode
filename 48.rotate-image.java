/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++)
            // start from i, avoid transpose rows that already set
            for (int j = i; j < m[0].length; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
    }

    public void reflect(int[][] m) {
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length / 2; j++) {
                int tmp = m[i][m[0].length - 1 - j];
                m[i][m[0].length - 1 - j] = m[i][j];
                m[i][j] = tmp;
            }
    }
}
// @lc code=end
