/*
 * @lc app=leetcode id=909 lang=java
 *
 * [909] Snakes and Ladders
 */

// @lc code=start

import java.util.Queue;

class Solution {
    int n;

    public int snakesAndLadders(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j <= Math.min(6, n * n - cur); j++) {
                    int next = cur + j;

                    int val = getBoardValue(board, next);
                    if (val != -1) {
                        next = val;
                    }
                    if (next == n * n) {
                        return step;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }

                }
            }
        }

        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[x][y];
    }

}

// @lc code=end
