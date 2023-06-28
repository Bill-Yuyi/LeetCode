/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start

import java.util.Queue;

class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1) {
            return -1;
        }
        queue.offer(new int[] { 0, 0 });
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) {
                    return step + 1;
                }
                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0], y = dir[1] + cur[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 0) {
                        continue;
                    }
                    grid[x][y] = 1;
                    queue.offer(new int[] { x, y });
                }
            }
            step++;
        }
        return -1;
    }
}
// @lc code=end
