/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */

// @lc code=start

import java.util.Queue;

class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int n;

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        int m = grid[0].length;
        int r = 0, c = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                    break;
                }
            }
        dfs(grid, r, c);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    ans = Math.min(ans, bfs(grid, i, j));
                }
            }
        return ans;

    }

    int bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        visited[i][j] = true;
        queue.offer(new int[] { i, j });
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0], y = dir[1] + cur[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return step;
                    } else {
                        visited[x][y] = true;
                        queue.offer(new int[] { x, y });
                    }
                }

            }
            step++;
        }
        return Integer.MAX_VALUE;
    }

    void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
// @lc code=end
