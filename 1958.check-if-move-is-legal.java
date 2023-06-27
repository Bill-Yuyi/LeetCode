/*
 * @lc app=leetcode id=1958 lang=java
 *
 * [1958] Check if Move is Legal
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int n = 8;
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        char op = color == 'W' ? 'B' : 'W';
        for (int[] dir : dirs) {
            int count = 1;
            int x = rMove + dir[0], y = cMove + dir[1];

            while (x >= 0 && x < n && y >= 0 && y < n && board[x][y] != '.') {
                if (count != 1 && board[x][y] == color)
                    return true;

                if (board[x][y] != op)
                    break;

                x += dir[0];
                y += dir[1];
                count++;
            }

        }
        return false;
    }
}
// @lc code=end
