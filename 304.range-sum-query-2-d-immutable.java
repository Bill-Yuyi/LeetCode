/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    int[][] sum;
    int n;
    int m;

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        sum = new int[n][m];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < m; j++) {
            sum[0][j] = sum[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];
            }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] - (col1 - 1 < 0 ? 0 : sum[row2][col1 - 1]) - (row1 - 1 < 0 ? 0 : sum[row1 - 1][col2])
                + (row1 - 1 < 0 || col1 - 1 < 0 ? 0 : sum[row1 - 1][col1 - 1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
