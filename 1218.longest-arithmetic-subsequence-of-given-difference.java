/*
 * @lc app=leetcode id=1218 lang=java
 *
 * [1218] Longest Arithmetic Subsequence of Given Difference
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i] - difference;
            map.put(arr[i], map.getOrDefault(target, 0) + 1);
            max = Math.max(map.get(arr[i]), max);
        }
        return max;
    }
}
// @lc code=end
