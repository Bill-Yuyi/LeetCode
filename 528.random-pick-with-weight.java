import java.util.Random;

/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
    int[] prefixSum;
    Random rand = new Random();

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        return binary(target);
    }

    private int binary(int target) {
        if (prefixSum.length == 0) {
            return -1;
        }
        int left = 0, right = prefixSum.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] == target) {
                right = mid - 1;
            } else if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end
