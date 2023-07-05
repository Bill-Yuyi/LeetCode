/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start

import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        for (int num : nums) {
            pq.offer(String.valueOf(num));
        }
        if (pq.peek().charAt(0) == '0') {
            return "0";
        }
        String res = "";
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}
// @lc code=end
