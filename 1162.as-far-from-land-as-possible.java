/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 */

// @lc code=start

import java.util.Queue;

class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                }
            }
        int dist = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0], y = dir[1] + cur[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 1) {
                        continue;
                    }
                    queue.offer(new int[] { x, y });
                    grid[x][y] = 1;
                }

            }
            dist++;
        }
        return dist == 0 ? -1 : dist;
    }
}
// @lc code=end
