/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start

import java.util.Queue;

class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        if (fresh == 0) {
            return 0;
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (fresh == 0) {
                return step;
            }
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 1) {
                        continue;
                    }
                    queue.offer(new int[] { x, y });
                    grid[x][y] = 2;
                    fresh--;
                }
            }
            step++;
        }
        return fresh == 0 ? step : -1;
    }
}
// @lc code=end
