/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
import java.util.*;

class Solution {
    HashMap<Long, Integer> map = new HashMap<>();
    int k;
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        this.k = targetSum;
        backtrack(root, 0L);
        return res;

    }

    // use cursum to track current sum, put it in the map, and record res++ if
    // cursum - k is in map
    // that is to say, there was prefix sum in the path.
    void backtrack(TreeNode node, long cursum) {
        if (node == null) {
            return;
        }
        cursum += node.val;
        if (cursum == k) {
            res++;
        }

        res += map.getOrDefault(cursum - k, 0);
        map.put(cursum, map.getOrDefault(cursum, 0) + 1);
        backtrack(node.left, cursum);
        backtrack(node.right, cursum);
        map.put(cursum, map.get(cursum) - 1);
    }

}
// @lc code=end
