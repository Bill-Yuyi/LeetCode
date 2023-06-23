/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int islandPerimeter(int[][] grid) {
        int ans = 0, n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int count = 0;
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        if (i + dir[0] < 0 || i + dir[0] >= n || j + dir[1] < 0 || j + dir[1] >= m
                                || grid[i + dir[0]][j + dir[1]] == 1) {
                            continue;
                        }

                        count++;
                    }
                    if (i == 0)
                        count++;
                    if (i == n - 1) {
                        count++;
                    }

                    if (j == 0)
                        count++;
                    if (j == m - 1) {
                        count++;
                    }
                    ans += count;
                }

            }
        return ans;
    }

}
// @lc code=end
