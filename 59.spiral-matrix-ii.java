/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int leftBound = 0, rightBound = n - 1, upBound = 0, lowerBound = n - 1;
        int count = 1;
        while (count <= n * n) {
            // going right;
            for (int i = leftBound; i <= rightBound && count <= n * n; i++) {
                res[upBound][i] = count;
                count++;
            }
            upBound++;
            // going donw
            for (int j = upBound; j <= lowerBound && count <= n * n; j++) {
                res[j][rightBound] = count;
                count++;
            }
            rightBound--;
            // going left
            for (int i = rightBound; i >= leftBound && count <= n * n; i--) {
                res[lowerBound][i] = count;
                count++;
            }
            lowerBound--;
            // going up
            for (int j = lowerBound; j >= upBound && count <= n * n; j--) {
                res[j][leftBound] = count;
                count++;
            }
            leftBound++;
        }
        return res;
    }
}
// @lc code=end
