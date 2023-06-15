/*
 * @lc app=leetcode id=768 lang=java
 *
 * [768] Max Chunks To Make Sorted II
 */

// @lc code=start
import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] minRight = new int[n];
        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], arr[i]);
        }
        int res = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(arr[i], max);
            if (max <= minRight[i + 1]) {
                res++;
            }
        }
        return res + 1;
    }
}
// @lc code=end
