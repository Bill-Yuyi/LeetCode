/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] h) {
        int n = h.length, m = h[0].length;
        Queue<int[]> a = new LinkedList<>();
        Queue<int[]> p = new LinkedList<>();
        boolean[][] at = new boolean[n][m];
        boolean[][] pa = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            p.offer(new int[] { 0, i });
            pa[0][i] = true;
            at[n - 1][i] = true;
            a.offer(new int[] { n - 1, i });
        }
        for (int i = 0; i < n; i++) {
            p.offer(new int[] { i, 0 });
            pa[i][0] = true;
            at[i][m - 1] = true;
            a.offer(new int[] { i, m - 1 });
        }

        bfs(h, a, at);
        bfs(h, p, pa);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (at[i][j] && pa[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        return ans;
    }

    void bfs(int[][] h, Queue<int[]> queue, boolean[][] sea) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x < 0 || x >= h.length || y < 0 || y >= h[0].length || h[cur[0]][cur[1]] > h[x][y] || sea[x][y]) {
                    continue;
                }
                queue.offer(new int[] { x, y });
                sea[x][y] = true;
            }
        }
    }
}
// @lc code=end
