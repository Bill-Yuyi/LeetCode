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
            for (int j = i; j < m[0].length; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
    }

    public void reflect(int[][] m) {
        for (int[] row : m) {
            int i = 0, j = row.length - 1;
            while (i < j) {
                int tmp = row[i];
                row[i] = row[j];
                row[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
// @lc code=end
