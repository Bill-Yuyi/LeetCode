/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);
        return res;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(max(root.left), 0);
        int right = Math.max(max(root.right), 0);
        res = Math.max(left + right + root.val, res);
        return Math.max(left, right) + root.val;
    }
}
// @lc code=end
