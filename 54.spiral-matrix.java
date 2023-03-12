import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int rightBound = m - 1, leftBound = 0, upBound = 0, downBound = n - 1;
        while (ans.size() < n * m) {
            // going right
            for (int i = leftBound; i <= rightBound && ans.size() < n * m; i++) {
                ans.add(matrix[upBound][i]);
            }
            upBound++;
            // going down
            for (int j = upBound; j <= downBound && ans.size() < n * m; j++) {
                ans.add(matrix[j][rightBound]);
            }
            rightBound--;
            // going left
            for (int i = rightBound; i >= leftBound && ans.size() < n * m; i--) {
                ans.add(matrix[downBound][i]);
            }
            downBound--;
            // going up
            for (int j = downBound; j >= upBound && ans.size() < n * m; j--) {
                ans.add(matrix[j][leftBound]);
            }
            leftBound++;
        }
        return ans;
    }
}
// @lc code=end
