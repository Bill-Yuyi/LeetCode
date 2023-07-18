/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        traverse(root, root.val, count);
        return count[0];
    }

    void traverse(TreeNode node, int maxNode, int[] count) {
        if (node == null) {
            return;
        }
        if (node.val >= maxNode) {
            count[0]++;
            maxNode = node.val;
        }
        traverse(node.left, maxNode, count);
        traverse(node.right, maxNode, count);

    }
}
// @lc code=end
