/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

import java.util.*;

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (st.isEmpty()) {
                st.push(asteroids[i]);
            } else {
                int cur = asteroids[i];
                while (!st.isEmpty() && st.peek() > 0 && cur < 0) {
                    int last = st.pop();
                    if (Math.abs(last) == Math.abs(cur)) {
                        cur = 0;
                        continue;
                    }
                    cur = Math.abs(last) > Math.abs(cur) ? last : cur;
                }
                if (cur == 0) {
                    continue;
                }
                st.push(cur);
            }
        }
        if (st.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[st.size()];
        int index = 0;
        for (int s : st) {
            ans[index++] = s;
        }
        return ans;
    }
}
// @lc code=end
