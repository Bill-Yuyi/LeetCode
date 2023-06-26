/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 */

// @lc code=start

import java.util.Queue;

class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int n = rooms.length, m = rooms[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        boolean[][] visited = new boolean[n][m];
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || rooms[x][y] == -1 || rooms[x][y] == 0 || visited[x][y]) {
                        continue;
                    }
                    rooms[x][y] = Math.min(step, rooms[x][y]);
                    visited[x][y] = true;
                    queue.offer(new int[] { x, y });
                }
            }
            step++;
        }

    }
}
// @lc code=end
