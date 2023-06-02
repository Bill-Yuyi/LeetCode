/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start

import java.util.List;

class Solution {
    public int reverse(int x) {
        long ans = 0;
        List<Integer> list = new ArrayList<>();
        int tmp = x;
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int times = 0;
        for (int j = 0; j < list.size(); j++) {
            if (j == 0 && list.get(j) == 0) {
                continue;
            }
            ans = ans * 10 + list.get(j);
        }

        return ans > ((long) Integer.MAX_VALUE) || ans < ((long) Integer.MIN_VALUE) ? 0 : (int) ans;
    }
}
// @lc code=end
