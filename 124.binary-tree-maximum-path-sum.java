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
        traverse(root);
        return res;
    }

    int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, traverse(node.left));
        int right = Math.max(0, traverse(node.right));
        res = Math.max(left + right + node.val, res);
        return Math.max(left, right) + node.val;
    }

}
// @lc code=end
