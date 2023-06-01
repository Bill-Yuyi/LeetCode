/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        for (int num : nums) {
            pq.offer(String.valueOf(num));
        }
        if (pq.peek().equals("0")) {
            return "0";
        }
        String res = new String();
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}
// @lc code=end
