/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        return checker(root, null, null);
    }

    public boolean checker(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min.val)
            return false;
        if (max != null && node.val >= max.val) {
            return false;
        }
        return checker(node.left, min, node) && checker(node.right, node, max);
    }
}
// @lc code=end
