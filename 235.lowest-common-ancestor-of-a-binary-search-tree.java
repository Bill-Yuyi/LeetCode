/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // p > q, change the position
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        // find in the right subtree
        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // find in the left subtree
        else if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // p.val <= root.val <= q.val return root
        return root;
    }
}
// @lc code=end
