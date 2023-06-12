/*
 * @lc app=leetcode id=873 lang=java
 *
 * [873] Length of Longest Fibonacci Subsequence
 */

// @lc code=start

import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[arr.length][arr.length];
        int ans = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < i; j++) {
                int index = map.getOrDefault(arr[i] - arr[j], -1);
                if (index >= 0 && index < j) {
                    int cur = Math.max(2, dp[index][j]) + 1;
                    dp[j][i] = cur;
                    ans = Math.max(ans, cur);
                }
            }
        return ans >= 3 ? ans : 0;
    }
}
// @lc code=end
