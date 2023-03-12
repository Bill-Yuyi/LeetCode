/*
 * @lc app=leetcode id=2536 lang=java
 *
 * [2536] Increment Submatrices by One
 */

// @lc code=start
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n];
        for (int[] query : queries) {
            diff[query[0]][query[1]] += 1;
        }
    }
}
// @lc code=end
