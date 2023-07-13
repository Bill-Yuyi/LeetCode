/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
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
    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        int[] min = new int[] { Integer.MAX_VALUE };
        traverse(root, min);
        return min[0];
    }

    void traverse(TreeNode node, int[] min) {
        if (node == null) {
            return;
        }
        traverse(node.left, min);
        if (prev != null) {
            min[0] = Math.min(node.val - prev.val, min[0]);
        }
        prev = node;
        traverse(node.right, min);
    }
}
// @lc code=end
